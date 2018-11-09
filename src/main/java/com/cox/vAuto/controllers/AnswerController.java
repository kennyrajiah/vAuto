package com.cox.vAuto.controllers;

import com.cox.vAuto.models.*;
import com.cox.vAuto.services.face.AnswerService;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.List;


@Api(value = "Answer-Controller", description = "One run to return Success")
@RestController
@RequestMapping("/api")
public class AnswerController {

    private AnswerService answerService;
    public static List<DealerIdModel>ss;
//    private Queue<CompletableFuture<DealerIdModel>> listOfDealerId;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/getvauto", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> getvAutoInfo() throws InterruptedException {

        VehicleModel  vehiclesInfo;
        CompletableFuture<DealerIdModel> dealerInfo;

        PostAnswerModel postModel;
        Dealers  dealersModel;
        VehicleInfoModel  vehicleInfoModel;


        List <CompletableFuture<DealerIdModel>> listOfDealerId = new ArrayList<>();
        List<VehicleModel> listOfvehicles = new ArrayList<>();

        List<Dealers> dealersList=new ArrayList<>();
        Map<Integer, DealerIdModel> uniqueDealerListMap = new HashMap<>();
        Multimap<Integer, VehicleInfoModel> listMultimap = ArrayListMultimap.create();


        //get datasetId
         String datasetId= answerService.getdatasetId();
        //get all vehicleIds
        VehicleIdModel vehicleIds=answerService.getvehicleIds(datasetId);


        for(int i=0;i<vehicleIds.getVehicleIds().size();i++) {
            //get vehicleinfo
            vehiclesInfo = answerService.getvehicleInfo(datasetId, vehicleIds.getVehicleIds().get(i));
            listOfvehicles.add(vehiclesInfo);
            listOfDealerId.add(answerService.getdealerInfo(datasetId, vehiclesInfo.getDealerId()));

        }

//        CompletableFuture.allOf(listOfDealerId).join();
        listOfDealerId.stream().map(CompletableFuture::join).collect(Collectors.toList());


       // https://spring.io/guides/gs/async-method/
        //https://stackoverflow.com/questions/416183/in-java-critical-sections-what-should-i-synchronize-on
//        public void foo() {
//            synchronized (this) {
//                // do something thread-safe
//            }
//              for (DealerIdModel dealer:listOfDealerId){
//                  //Dealers dealersModels= new Dealers(dealer.getDealerId(),dealer.getName(), );
////                  dealersModel.setDealerId(dealer.getDealerId());
////                  dealersModel.setName(dealer.getName());
////                  dealersModel.setVehicles(listOfvehicles.get());
//  //       List <VehicleInfoModel> s= listOfvehicles.stream().filter(p -> p.getDealerId().equals(dealer.getDealerId()).(Collectors.toList()));
//                          //toString()));
//
//                  Collection<VehicleModel> collection = new ArrayList<VehicleModel>(listOfvehicles);
//              List<VehicleModel> anotherLIST=       collection.stream().filter(p -> p.getDealerId()==dealer.getDealerId()).collect(Collectors.toList());
//              }


        for(Map.Entry<Integer, DealerIdModel> entry : uniqueDealerListMap.entrySet()) {
            Integer key = entry.getKey();
            DealerIdModel value = entry.getValue();
            //get list of vehicle Info per Dealer
            Collection<VehicleInfoModel> values = listMultimap.get(key);
            //create  model for each dealer
            dealersModel =new Dealers(uniqueDealerListMap.get(key).getDealerId(),uniqueDealerListMap.get(key).getName(),values.stream().collect(Collectors.toList()));
            //add each model to dealers List
            dealersList.add(dealersModel);

        }

          //use Dealers list to PostModel
         postModel =new PostAnswerModel(dealersList);

        return new ResponseEntity<>(answerService.postAnswer(datasetId,postModel), HttpStatus.OK);
    }


}
