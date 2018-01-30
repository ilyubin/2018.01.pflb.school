package ok.automation.tech.extensions;

import net.thucydides.core.pages.PageObject;

import java.util.function.Supplier;

public class Helper extends PageObject {
    public void doInFrame(String frameId, Runnable... f){
        getDriver().switchTo().frame(frameId);
        for(int i = 0; i < f.length; i++){
            f[i].run();
        }
        getDriver().switchTo().parentFrame();
    }
    public String doInFrame(String frameId, Supplier<String> f){
        getDriver().switchTo().frame(frameId);
        String result = f.get();
        getDriver().switchTo().parentFrame();
        return result;
    }


}
