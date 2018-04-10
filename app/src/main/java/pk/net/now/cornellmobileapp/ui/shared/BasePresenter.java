package pk.net.now.cornellmobileapp.ui.shared;

/**
 * Created by Qamar on 9/4/2017.
 */

public abstract class BasePresenter<T extends BaseView> {


    public T view;

    public void attach(T view){
        this.view = view;
    }

    public boolean isAttached() {
        return view != null;
    }

    public void detach(){
        this.view = null;
    }
}
