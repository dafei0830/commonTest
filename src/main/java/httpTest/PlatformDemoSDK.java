package httpTest;

import com.alibaba.fastjson.JSONObject;
import com.mucfc.fep.base.CommonServiceRequest;
import com.mucfc.fep.base.CommonServiceResponse;
import com.mucfc.fep.base.ServiceExecutor;
import com.mucfc.fep.sdk.exception.ServiceRequestException;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/1/8 17:49
 **/
public class PlatformDemoSDK {
    public static void main(String[] args) throws Exception {
        CommonServiceRequest request = new CommonServiceRequest();
        //设置公共参数
        request.setAppId("10004");
        request.setReqServiceId("api.token");
        request.setFlowNo("10004" + System.currentTimeMillis());
        request.setMerchantId("1040003");
        request.setSubMerchantId("");//有的话设置
        request.setOpenId("88888888");
        request.setEncryptType("AES");

        //业务参数
        JSONObject bizContent = new JSONObject();
        bizContent.put("merchantId", "21900002");
        request.setBizContent(bizContent.toJSONString());
        CommonServiceResponse resp = ServiceExecutor.execute(request);
        System.out.println(resp);

        //获取返回业务数据
        JSONObject tokenObj = JSONObject.parseObject(resp.getBizContent());
        System.out.println("token : " + tokenObj.getString("key"));
        String token = tokenObj.getString("key");
        System.out.println(token);
    }
}
