package massive.task.com.common;


public interface Constants {

    interface Common {
String FROM="from";
    }

    interface InternalHttpCode{
        int SUCCESS_CODE = 200;
        int FAILURE_CODE = 0;
    }
interface AccountKitCode{
        int REQUEST_CODE = 100;
    }

    interface HttpErrorMessage{
        String INTERNAL_SERVER_ERROR = "Our server is under maintenance. We will reslove shortly!";
        String FORBIDDEN = "Seems like you haven't permitted to do this operation!";

    }

    interface NetworkType {
        String WIFI = "Wi-Fi";
        String MOBILE = "Mobile";
    }

    interface BundleKey {

    }

    interface RequestCodes {
        int KEY_REQUEST_CODE_COMPOSE_MAIL = 101;
    }

    interface BroadCastKey {

    }

    interface SharedPrefKey {

    }

    interface ApiRequestKey{

    }

}
