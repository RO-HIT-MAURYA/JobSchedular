package greenbox.user.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.adoisstudio.helper.H;
import com.adoisstudio.helper.Session;
import com.greenbox.user.R;

import java.util.ArrayList;
import java.util.List;

import greenbox.user.commen.P;
import greenbox.user.database.DatabaseHelper;
import greenbox.user.entities.Visitor;
import greenbox.user.fragments.AboutAppFragment;
import greenbox.user.fragments.EventAgendaFragment;
import greenbox.user.fragments.EventDescFragment;
import greenbox.user.fragments.EventListFragment;
import greenbox.user.fragments.HallSelectionFragment;
import greenbox.user.fragments.HomeFragment;
import greenbox.user.fragments.MyProfileFragment;
import greenbox.user.fragments.NotificationFragment;
import greenbox.user.fragments.ScannerScreenFragment;
import greenbox.user.fragments.SearchFragment;


public class ClientListActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    public LinearLayout homeButtonLayout, notiButtonLayout, searchButtonLayout, profileButtonLayout;
    public HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private SearchFragment searchFragment;
    private MyProfileFragment myProfileFragment;
    public EventListFragment eventlistFragment;
    public EventDescFragment eventDescFragment;
    public HallSelectionFragment hallSelectionFragment;
    public EventAgen