package com.sjs.do8_packegemanager;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        ListView listView = findViewById(R.id.list_View);

        PackageManager pm = getPackageManager();
        final List<ApplicationInfo> infos = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        AppInfoAdapter adapter = new AppInfoAdapter(infos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ApplicationInfo info = infos.get(position);
                ApplicationInfo info = (ApplicationInfo) parent.getAdapter().getItem(position);
                Intent intent = new Intent();
                intent.putExtra("info", info);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
