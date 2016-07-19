package com.yifan.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yifan.greendaodemo.database.DataBaseManager;
import com.yifan.greendaodemo.entity.Projects;
import com.yifan.greendaodemo.gen.ProjectsDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv_main);
        writeData();
        mTextView.setText(getProjects());

    }

    private void writeData() {
        Projects projects = new Projects(null, "随手科技", String.valueOf(System.currentTimeMillis()), 123);
        DataBaseManager.getInstance().getProjectsDao().insert(projects);
    }

    public String getProjects() {
        List<Projects> list = DataBaseManager.getInstance().getProjectsDao()
                .queryBuilder().where(ProjectsDao.Properties.Id.notEq(999)).orderAsc(ProjectsDao.Properties.Id)
                .limit(5).build().list();
        StringBuilder stringBuilder = new StringBuilder();
        for (Projects projects : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(projects.toString());
        }
        return stringBuilder.toString();
    }
}
