package co.in.kethan.attendance_manager.views;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.in.kethan.attendance_manager.R;
import co.in.kethan.attendance_manager.context.AppContext;
import co.in.kethan.attendance_manager.controllers.AttendanceCountAdapter;
import co.in.kethan.attendance_manager.models.Attendance;

public class ViewAttendancePerStudentActivity extends AppCompatActivity {

    ArrayList<Attendance> attendanceBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view_layout);

        TextView titleTextView = findViewById(R.id.textView_title);
        titleTextView.setText(R.string.ATTENDANCE_REPORT);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

        attendanceBeanList = ((AppContext) this.getApplicationContext()).getAttendanceList();

        AttendanceCountAdapter adapter = new AttendanceCountAdapter(attendanceBeanList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}