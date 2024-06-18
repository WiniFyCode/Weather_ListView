package com.example.weatherlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<WeatherItem> weatherItem = new ArrayList<>();

        // Tạo danh sách các tỉnh thành
        String[] cities = {
                "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định",
                "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk",
                "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội",
                "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang",
                "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình",
                "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị",
                "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang",
                "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"
        };

        // Tạo danh sách các trạng thái thời tiết
        String[] statuses = {
                "Có mây", "Mưa", "Mưa sấm sét", "Nắng", "Nắng mây ít", "Nắng mây nhiều", "Nắng sấm sét"
        };

        // Tạo danh sách các hình ảnh
        int[] imageResources = {
                R.drawable.may, R.drawable.mua, R.drawable.muasamset, R.drawable.nang,
                R.drawable.nangmayit, R.drawable.nangmaynhieu, R.drawable.nangsamset
        };

        // Tao danh sach cac muc thoi tiet
        List<WeatherItem> weatherItems = new ArrayList<>();
        Random random = new Random();

        for (String city : cities) {
            int degree = random.nextInt(20) + 15; // ramdon nhiet do tu 20 -> 39;
            String status = statuses[random.nextInt(statuses.length)]; // random trang thai
            int imageResource = imageResources[random.nextInt(imageResources.length)]; // random hinh anh
            weatherItems.add(new WeatherItem(city, degree, status, imageResource));
        }

        // tao Adapter
        WeatherListAdapter adapter = new WeatherListAdapter(this, weatherItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                WeatherItem item = weatherItems.get(position);

                Intent intent = new Intent(MainActivity.this, Detail_Activity.class);
                intent.putExtra("city", item.getCity());
                intent.putExtra("degree", item.getDegree());
                intent.putExtra("status", item.getStatus());
                intent.putExtra("image", item.getImage());
                startActivity(intent);
            }
            });
    }
}