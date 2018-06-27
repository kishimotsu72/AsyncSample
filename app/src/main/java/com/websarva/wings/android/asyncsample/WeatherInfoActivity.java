package com.websarva.wings.android.asyncsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class WeatherInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);


        ListView lvCityList = findViewById(R.id.lvCityList);

        List<Map<String, String>> cityList = new ArrayList<>();

        Map<String, String> city = new HashMap<>();

        city.put("name", "大阪");
        city.put("id", "270000");
        cityList.add(city);
        city = new HashMap<>();

        city.put("name","神戸");
        city.put("id", "280010");
        cityList.add(city);

        String[] from = {"name"};
        int[] to = {android.R.id.text1};

        SimpleAdapter adapter = new SimpleAdapter(WeatherInfoActivity.this, cityList, android.R.layout.simple_expandable_list_item_1, from, to);

        lvCityList.setAdapter(adapter);

        lvCityList.setOnItemClickListener(new ListItemClickListener());

    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?>parent,View view,int position, long id){
    Map<String,String> item = (Map<String,String>)parent.getItemAtPosition(position);
    String cityName = item.get("name");
String cityId = item.get("id");
            TextView tvCityName =findViewById(R.id.tvCityName);
            tvCityName.setText(cityName + "の天気：");
}

    }
}
