package xdu.edu.cn.calculator;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Harold on 2016/12/27.
 */

public class aboutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        PackageManager manager = getPackageManager();
        PackageInfo info = null;

        try{
            info = manager.getPackageInfo(getPackageName(),0);
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        String version = info == null?"Unknow":info.versionName;
        String msg = String.format("Version: %s Designer: Harold",version);
        TextView ver = (TextView) this.findViewById(R.id.version_info);
        ver.setText(msg);
    }
}
