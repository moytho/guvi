package com.guvi.gt.lataxi.net.invokers;


import org.json.JSONObject;

import java.util.HashMap;

import com.guvi.gt.lataxi.model.SuccessBean;
import com.guvi.gt.lataxi.net.ServiceNames;
import com.guvi.gt.lataxi.net.WebConnector;
import com.guvi.gt.lataxi.net.parsers.SuccessDetailsParser;
import com.guvi.gt.lataxi.net.utils.WSConstants;

public class SuccessDetailsInvoker extends BaseInvoker{

    public SuccessDetailsInvoker() {
        super();
    }

    public SuccessDetailsInvoker(HashMap<String, String> urlParams,
                           JSONObject postData) {
        super(urlParams, postData);
    }

    public SuccessBean invokeSuccessDetailsWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.TRIP_COMPLETION_DETAILS), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service(true);
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        SuccessBean successBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
			registerBean.setWebError(true);*/
            return successBean = null;
        } else {
            successBean = new SuccessBean();
            SuccessDetailsParser successDetailsParser = new SuccessDetailsParser();
            successBean = successDetailsParser.parseSuccessDetailsResponse(wsResponseString);
            return successBean;
        }
    }
}
