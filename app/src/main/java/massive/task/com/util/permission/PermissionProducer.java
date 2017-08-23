package massive.task.com.util.permission;


import massive.task.com.view.iview.IView;

public interface PermissionProducer extends IView {
    void onReceivedPermissionStatus(int code, boolean isGrated);
}
