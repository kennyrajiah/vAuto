//package com.cox.vAuto.controllers;
//
//import com.cox.vAuto.models.Dealers;
//import com.cox.vAuto.models.PostAnswerModel;
//import com.cox.vAuto.models.ResponseModel;
//import com.cox.vAuto.models.VehicleInfoModel;
//import com.cox.vAuto.services.face.AnswerService;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.Boolean.TRUE;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class AnswerControllerTest {
//
//     String DATASET_ID = "9mjAHFtH1gg";
//
//    @MockBean
//    private AnswerService answerService;
//
//    private AnswerController answerController;
//    private List<Dealers> mockDealers;
//    private PostAnswerModel mockPostAnswer;
//    private PostAnswerModel mockPostAnswerFailed;
//    private List<Dealers> mockDealersFailed;
//
//
//
//    @Before
//    public void setUp() throws Exception {
//
//        answerController =new AnswerController(answerService);
//
//        //createListofVehicleModel for each Dealers
//        List<VehicleInfoModel> vehicleInfoModel1 =new ArrayList<>();
//        vehicleInfoModel1.add(new VehicleInfoModel(730815962,2016,"Honda","Accord"));
//        vehicleInfoModel1.add(new VehicleInfoModel(1895619684,2014,"Ford","F150"));
//        vehicleInfoModel1.add(new VehicleInfoModel(1256762042,2004,"MINI","Cooper"));
//
//        List<VehicleInfoModel> vehicleInfoModel2 =new ArrayList<>();
//        vehicleInfoModel2.add(new VehicleInfoModel(1720876079,2013,"Mitsubishi","Gallant"));
//        vehicleInfoModel2.add(new VehicleInfoModel(140702328,2009,"Ford","Ford"));
//        vehicleInfoModel2.add(new VehicleInfoModel(1955214401,2016,"Kia","Soul"));
//
//        List<VehicleInfoModel> vehicleInfoModel3 =new ArrayList<>();
//        vehicleInfoModel3.add(new VehicleInfoModel(124335133,2016,"Bentley","Mulsanne"));
//        vehicleInfoModel3.add(new VehicleInfoModel(1583907312,2012,"Nissan","Altima"));
//        vehicleInfoModel3.add(new VehicleInfoModel(206292565,1979,"Cheverolet","Corvette"));
//
//        mockDealers.add(new Dealers(1224023331,"Bob's Cars",vehicleInfoModel1));
//        mockDealers.add(new Dealers(1536732225,"House of Wheels",vehicleInfoModel2));
//        mockDealers.add(new Dealers(338966195,"Doug's Doozies",vehicleInfoModel3));
//
//        mockDealersFailed.add(new Dealers(1224023331,"Bob's Cars",vehicleInfoModel1));
//        mockDealersFailed.add(new Dealers(1536732225,"House of Wheels",vehicleInfoModel2));
//        mockDealersFailed.add(new Dealers(338966195,"Doug's Doozies",null));
//
//
//        mockPostAnswer.setDealers(mockDealers);
//        mockPostAnswerFailed.setDealers(mockDealersFailed);
//
//        ResponseModel success=new ResponseModel(TRUE,"congratulations",25438);
//        ResponseModel failed=new ResponseModel(TRUE,"congratulations",25438);
//
//
//
//
//      // when(answerService.postAnswer(Mockito.eq(DATASET_ID,success))).thenReturn(success);
//
//
//
//    }
//
//   // @Test
//    @Ignore
//    public void getAllStations_happyPath_test() {
//
//        ResponseModel answer = answerService.postAnswer(DATASET_ID,mockPostAnswer);
//        // then
//        assertNotNull(answer);
//        assertTrue(answer.getSuccess());
//    }
//
//
//
//
//
//}
