package com.cox.vAuto.services.face;

import com.cox.vAuto.models.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public interface AnswerService {

    String getdatasetId ();
    VehicleIdModel getvehicleIds (String datasetId);
    VehicleModel getvehicleInfo (String datasetId, Integer vehicleId) ;
    CompletableFuture<DealerIdModel>  getdealerInfo(String datasetId,Integer dealerId);
    ResponseModel postAnswer(String dataset,PostAnswerModel postAnswerModel);

}
