package com.studybymyself.candcloud.util;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Result<T> {

    public enum ResultCode {
        SUCCESS(200, "成功"),
        GATEWAY_SUCCESS(0, "成功"),
        INTERNAL_ERR(4004, "内部配置错误"),
        BIZ_ERROR_SYSTEM(4005, "系统错误"),

        //rrpc
        RRPC_NOT_RESPONSE(4006, "下发RRPC未收到响应"),

        //call api error
        CALL_REMOTE_API_ERROR(2000, "服务端调用API失败"),
        REMOTE_API_ERROR(2001, "远程API失败"),
        PARAMETERS_IS_EMPTY(2002, "参数为空"),
        PARAMETERS_IS_ERROR(2002, "参数错误"),
        PARAMETERS_IS_NOT_VALID_JSON(2003, "不是有效Json数据"),
        COMMAND_NOT_EXIST(2004, "命令不存在"),
        RECORD_NOT_EXIST(2005, "信息不存在"),
        OPERATE_TYPE_NOT_EXIST(2006, "操作类型不存在"),
        PARAMETERS_IS_NOT_VALID_JSON_ARRAY(2007, "不是有效JsonArray数据"),


        PRODUCT_NAME_IS_EMPTY(11001, "产品名字不能为空"),
        PRODUCT_MODEL_IS_EMPTY(11002, "产品Model不能为空"),
        PRODUCT_EXISTS(11003, "产品已存在"),
        PRODUCT_CALL_CREATE_API_ERROR(11004, "创建产品调用API失败"),
        PRODUCT_NOT_EXISTS(11005, "产品不存在"),
        PRODUCT_KEY_IS_EMPTY(11006, "ProductKey不能为空"),
        PRODUCT_ID_IS_EMPTY(11007, "产品ID不能为空"),
        PRODUCT_MODEL_EXISTS(11008, "产品Model已存在"),

        PROJECT_ID_NOT_NULL(11010, "项目ID不能为空"),
        PROJECT_NOT_EXISTS(11011, "项目不存在"),
        NO_PROJECT_PERMISSION(11012, "无此项目权限"),


//        PRODUCT_PROPERTY_JSON_ERROR(11009,""),
//        GATEWAY_PRODUCT_NOT_EXISTS(11010),//网关所属产品不存在


        //设备相关

        DEVICE_NAME_IS_EMPTY(13002, "设备名字为空"),
        DEVICE_EXISTS(13003, "设备已经存在"),
        DEVICE_NOT_EXISTS(13004, "设备不存在"),
        DEVICE_HAS_CHILD(13005, "设备有子ID"),
        PARENT_DEVICE_NOT_EXISTS(13006, ""),
        GATEWAY_EXISTS_DEVICE(13007, "网关下存在设备"),
        GATEWAY_NOT_EXISTS(13008, "网关不存在"),
        NO_PERMISSION_ADD_CHILD_TO_GATEWAY(13009, "没有权限添加子设备到网关"),
        ADD_TO_GATEWAY_FAILED(13010, "添加到网关失败"),//添加到网关失败
        DEVICE_ID_IS_EMTPTY(13011, "设备ID为空"),
        DEVICE_IS_NOT_ACTIVTED(13012, "设备还未激活"),//设备还未激活
        DEVICE_HAS_BIND(13013, "设备已绑定"),//设备已绑定
        GATEWAY_ID_IS_EMPTY(13014, "网关id为空"),//网关id为空
        DEVICE_STATE_NULL(13015, "设备状态为空"),
        GATEWAY_IS_REQUIRED(13016, "必须传入网关的信息"),//必须传入网关的信息
        DEVICE_TYPE_NOT_GATEWAY(13017, "设备类型不是网关"),//设备类型不是网关
        DEVICE_ID_QUERY_NULL(13018, "设备查询为空"),
        DEVICE_TYPE_IS_WRONG(13019, "设备类型不正确"),//设备类型不正确
        UUID_IS_EMPTY(13020, "uuid为空"),//uuid为空
        MAC_IS_EMTPY(13021, "mac地址为空"),//mac地址为空
        PLACE_HOLDER_NOT_EXISTS(13022, "坑位不能为空"),
        PLACE_HOLDER_HAS_BEEN_BIND(13023, "坑位已经绑定"),
        PLACE_HOLDER_NOT_BIND(13024, "坑位未绑定"),
        GATEWAY_NOT_BIND(13025, "gateway not bind"),
        DEVICE_DEVICEID_PRODUCTKEY_NOT_EQUAL(13026, "创建设备DeviceId和ProductKey不能重复"),
        DEVICE_NODETYPE_IS_EXISTS(13027, "设备类型不能为空"),//设备类型不正确
        SUBDEVICE_NOT_EXISTS(13028, "子设备不能为空"),
        DEVICEKEY_IS_EMPTY(13029, "DeviceKey不能为空"),
        DEVICE_PROPERTY_NAME_NOT_EXISTS(13030, "此设备没有这个回路"),
        DEVICE_STATUS_OFFLINE(13031, "设备处于离线状态"),
        DEVICE_EXECUTE_FAILURE(13032, "有设备执行失败"),
        DEVICE_PLATFORM_ERROR(13033, "非HomeLink平台设备或IotId不存在"),
        DEVICE_REGISTERED(13034, "设备已经注册"),
        DEVICE_UNREGISTER_FAILURE(13035, "设备注销失败"),
        DEVICE_NAME_EXISTS(13036, "设备名字重复"),
        DEVICE_SOURCE_ERROR(13037, "房屋不支持接入该渠道的设备"),
        DEVICE_WHOLE_NOT_EXISTS(13038, "整体设备不存在,或设备未注册"),
        DEVICE_WHOLE_HAVE_SUB_DEVICE(13039, "整体设备下有分解设备未删除"),
        DEVICE_DUPLICATE(13040, "该设备（MAC）在平台上不唯一"),


        //发送指令相关 Instruction
        INSTRUCTION_PAYLOAD_IS_EMPTY(14001, "发送指令内容为空"),
        //        INSTRUCTION_ACTIONCODE_IS_EMPTY(14002,"发送指令Code为空"),
        INSTRUCTION_DEVICEKEY_IS_EMPTY(14003, "发送指令DeviceKey为空"),
        PROPERTY_IS_EMTPY(14004, "属性名字为空"),
        PROPERTY_VALUE_IS_EMPTY(14005, "属性值为空"),
        PROPERTY_VALUE_IS_ERROR(14006, "属性值错误"),
        SERVER_PROPERTY_VALUE_IS_EMPTY(14007, ""),
        SEND_SHADOW_SUCCESS(14008, "发送影子成功"),
        SEND_SHADOW_FAIL(14009, "发送影子失败"),
        SEND_SCENE_FAIL(14010, "场景改变，通知网关失败"),
        GATEWAY_NOT_ACTIVE(14011, "网关没有激活"),
        BIND_SERVICE_FAIL(14012, "绑定服务失败"),
        GET_SHADOW_FAIL(14013, "获取影子失败"),
        RRPC_GATEWAY_FAIL(14014, "网关处理异常"),
        RRPC_GATEWAY_RETURN_FAIL(14015, "网关处理异常返回"),
        GATEWAY_NOT_REPEAT_BIND(14016, "当前网关已绑定房屋"),


        //场景相关
        GATEWAY_ID_VALUE_IS_EMPTY(15001, "网关ID为空"),
        SCENE_NAME_VALUE_IS_EMPTY(15002, "场景名字为空"),
        SCENE_TYPE_VALUE_IS_EMPTY(15003, "场景类型错误"),
        SCENE_ACTION_VALUE_IS_EMPTY(15004, "场景Action值为空"),
        SCENE_CREATE_FAIL(15005, "场景创建失败"),
        SCENE_NOT_EXISTS(15006, "场景不存在"),
        SCENE_ACTION_VALUE_NOT_JSON(15007, "场景Action非有效JSON"),
        SCENE_ID_VALUE_IS_EMPTY(15008, "场景ID为空"),
        SCENE_DELETE_FAIL(15009, "场景删除失败"),
        SCENE_IDS_VALUE_IS_EMPTY(15010, "场景Ids为空"),
        SCENE_SORT_ERROR(15011, "场景排序错误"),
        SCENE_MODIFY_FAIL(15012, "场景修改失败"),
        SCENE_QUERY_EXCEPTION(15013, "场景检索异常"),
        SCENE_SAFETY_IS_EXISTS(15014, "安防场景已存在"),
        SCENE_NAME_NOT_REPEAT(15015, "场景名字不能重复"),
        SCENE_IS_EXISTS(15016, "场景已存在"),
        USER_NO_COMMON_SCENARIO(15017, "该用户无常用场景"),
        COMMON_SCENE_EXISTS(15018, "该常用场景已存在"),
        COMMON_SCENE_DELETE_FAIL(15019, "常用场景删除失败"),
        SCENE_MUST_ALL_HOUSE(15020, "场景类型必须为全屋场景才可作为初始化预设场景"),
        SCENE_NO_ALL_HOUSE(15021, "该用户无全屋场景,初始化预设场景"),
        SCENE_UPDATE_FAILED(15022, "场景更新失败"),
        COMMON_SCENE_NOT_EXISTS(15023, "该用户无该常用场景"),
        NO_COMMON_SCENARIO(15024, "该场景用户未设为常用场景"),
        COMMON_SCENE_MODIFY_FAIL(15025, "常用场景修改失败"),
        COMMON_SCENE_INSERT_FAIL(15026, "常用场景新增失败"),
        USERID_NOT_NULL(15027, "用户id不能为空"),
        SCENE_TEMPLATE_NOT_EXISTS(15028, "该用户下该房子下没有安装此场景"),


        //房子相关
        HOUSE_ID_VALUE_IS_EMPTY(16001, "房子ID为空"),
        HOUSE_MOBILE_VALUE_IS_EMPTY(16002, "房子电话号码为空"),
        HOUSE_NOT_EXISTS(16003, "房子不存在"),
        USER_NOT_EXISTS(16004, "用户不存在"),
        HOUSE_BINDED(16005, "房子已经绑定"),
        HOUSE_NOT_BINDED(16006, "房子没有绑定"),
        HOUSE_TYPE_NOT_EXISTS(16007, "户型不存在"),
        HOUSE_HAS_BEEN_DEPLOYED(16008, "房子已经部署"),
        HOUSEROOM_NOT_EXISTS(16009, "房间不存在"),
        HOUSEROOMID_NOT_NULL(16010, "房间Id为空"),
        HOUSEROOM_NAME_NOT_NULL(16011, "房间名字不能为空"),
        HOUSE_BINDED_YOU(16012, "您已经绑定该房子"),
        PERMISSION_NO_HOUSE_BINDED_MASTER(16013, "没有权限绑定为户主"),
        USER_TYPE_ERROR(16014, "用户类型错误"),
        PERMISSION_NO_GET_NOTMASTER(16015, "非户主不能获取"),
        PERMISSION_NO_UNBIND_OTHER(16016, "非户主不能解绑其他用户"),
        MASTER_NO_UNBIND_MASTER(16016, "户主不能解绑户主"),
        CONFIG_LOCK_FINGERPRINT_ERR(16017, "门锁信息配置失败"),
        MOBILE_PHONE_EXIST(16018, "手机号码已存在"),
        HOUSE_NOT_USER(16019, "此房子非用户名下"),
        MODELHOUSE_NOT_EXISTS(16020, "样板房不存在"),
        HOUSE_NAME_NOT_NULL(16021, "样板房名字不能为空"),
        HOUSE_NAME_NOT_EQUAL(16022, "样板房名字不能重名"),
        HOUSE_NOT_ROOM(16023, "房子与房间不匹配"),

        HOUSE_TYPE_CREATE_FAILED(16024, "生成户型失败"),
        HOUSE_PLATEFORM_TYPE_NOT_NULL(16025, "房屋网关平台类型不能为空"),
        HOUSE_TYPE_EXIST(16026, "户型名称已存在"),

        //语音相关
        VOICE_NOT_EXISTS(17001, "声控不存在"),


        //联动相关
        LINKAGE_NOT_EXISTS(18001, "联动不存在"),
        LINKAGE_TIME_ERROR(18002, "联动时间错误"),
        LINKAGE_ENABLE_IS_NULL(18003, "联动启用为空"),
        LINKAGE_DELETE_FAILED(18004, "联动删除失败"),
        LINKAGE_ADD_FAILED(18005, "联动添加失败"),
        LINKAGE_MODIFY_FAILED(18006, "联动修改失败"),

        //多控相关
        MULTICONTROL_NOT_EXISTS(19001, "多控不存在"),
        MULTICONTROL_BOUND_AUXILIARY_CONTROL(19002, "此设备为主控,且已绑定其他辅控设备"),

        //SDS相关
        QRKEY_INVALID(19001, "二维码失效"),
        FILE_NOT_EXIST(19002, "文件不存在"),
        //用户相关
        NOT_LOGIN(1001, "未登录"),
        NO_PERMISSION(1002, "没有权限"),
        TOKEN_INVALID(1003, "TOKEN失效"),
        NO_REGISTER(1004, "未注册"),
        PASSWORD_ERROR(1005, "密码错误"),
        AUTH_CODE_ERROR(1006, "验证码错误"),
        MOBILE_IS_EMPTY(1007, "电话号码为空"),
        PASSWORD_IS_EMPTY(1008, "密码为空"),
        REGISTED(1009, "已注册"),
        MISSING_PASSWORD_AUTHCODE(1010, "缺失密码或者验证码"),
        CODE_INVALID(1011, "CODE无效"),
        DEVICE_INVALID(1012, "设备无效"),
        SIGN_INVALID(1013, "签名无效"),
        APPKEY_INVALID(1014, "APPKEY无效"),
        GATEWAY_URL_INVALID(1015, "网关URL无效"),
        MOBILE_REGISTED(10016, "电话号码已经注册"),
        AUTH_CODE_INVALID(1017, "验证码无效"),
        PERMISSION_NO_SHARE_HOUSE(1018, "没有权限分享房子"),
        NEWMOBILE_EQUAL_OLDMIBILE(1019, "新手机号与旧手机号不能相同"),
        SYS_TYPE_EMPTY(1020, "手机系统不能为空"),
        USER_TYPE_EMPTY(1021, "用户类型不能为空"),
        NEWPASSWORD_EQUAL_OLDPASSWORD(1022, "新密码与旧密码不能相同"),

        NO_ALARM_CONTACT(1023, "报警联系人不存在"),
        MAC_EMPTY(1024,"MAC地址不能为空"),
        APPKEY_EMPTY(1025,"APPKEY不能为空"),

        //houseType
        BUILD_HOUSE_TYPE_FAILD(3001, "生成户型-创建房子失败"),
        BUILD_HOUSE_TYPE_ROOM_FAILD(3002, "生成户型-房间模版失败"),
        BUILD_HOUSE_TYPE_DEVICE_FAILD(3003, "生成户型-创建坑位失败"),
        BUILD_HOUSE_TYPE_SCENE_FAILD(3004, "生成户型-创建场景失败"),
        BUILD_HOUSE_TYPE_DEVICE_GROUP_FAILD(3005, "生成户型-创建设备组失败"),
        BUILD_HOUSE_TYPE_DEVICE_GROUP_LINKED_FAILD(3006, "生成户型-创建设备组与设备关联信息失败"),

        //house delivery
        HOUSE_DELIVERY_APPLICATION_NOT_EXIST(7001, "该审核记录不存在"),
        HOUSE_NOT_DELIVERYT(7002, "房屋审核失败，房屋还未交付"),
        HOUSE_NOT_WAIT_DELIVERYT(7003, "房屋未处于待交付状态"),
        HOUSE_DELIVERYT_INVALID(7004, "房屋审核单已失效"),
        HOUSE_STATUS_DELIVERYT_INVALID(7005, "房屋审核失败，未处于交付异常状态"),
        HOUSE_GATEWAY_PLATFORM_INVALID(7006, "部署失败，该房屋不支持接入此类型网关"),

        //house QA
        QA_HOUSE_TESTING(8001, "房子正在进行QA测试中"),
        QA_START_TEST_ERR(8002, "发起QA测试失败"),
        QA_HOUSE_GATEWAY_OFFLINE(8003, "网关未在线"),
        QA_DEVICE_PIT_ERROR(8004, "设备未完成全部入坑"),
        QA_DEVICE_TEST_PASS(8005, "QA检测已通过"),
        QA_DEVICE_TEST_OVER(8006, "本次QA检测已结束"),
        QA_CODE_NOT_EXIST(8007, "QaCode不存在"),
        QA_NOT_START_TEST(8008, "Qa测试数据正在准备中"),


        //device group
        DEVICE_GROUP_NOT_EXIST(5001, "设备组不存在"),
        DEVICE_GROUP_NOT(5002, "设备未分组"),
        HOUSE_TYPE_DEVICE_GROUP_NOT_EXIST(5003, "设备组模版不存在"),
        DEVICE_GROUP_LINKED_NOT_EXIST(5004, "设备未分组"),

        //product group
        PRODUCT_GROUP_NOT_EXIST(6001, "产品组不存在"),
        //绿城相关
        ACCESSTOKEN_NOT_NULL(1024,"accessToken不能为空"),
        LOGINMESSAGE_NOT_USE(100017,"登录信息失效，请重新登录"),

        TEMPLATE_NOT_FAND(7000,"模板匹配错误")

        ;

        private int value;
        private String msg;

        ResultCode(int value, String msg) {
            this.value = value;
            this.msg = msg;
        }

        public int getValue() {
            return value;
        }

        public String getMsg() {
            return msg;
        }

        public static ResultCode parseValue(int value) {
            ResultCode[] values = ResultCode.values();
            for (ResultCode resultCode : values) {
                if (resultCode.getValue() == value) {
                    return resultCode;
                }
            }
            return null;
        }
    }

    private int code = 0;
    private String errmsg;
    private String msg;
    private T object;

    public Result() {
    }


    public Result(int code, String errMsg, String msg) {
        this.code = code;
        this.errmsg = errMsg;
        this.msg = msg;
    }

    public static <T> Result<T> withErr(Result.ResultCode resultCode) {
        return new Result<>(resultCode.value, resultCode.name(), resultCode.msg);
    }

    public static <T> Result<T> withErr(Result.ResultCode resultCode,String msg) {
        return new Result<>(resultCode.value, resultCode.name(), msg);
    }
}