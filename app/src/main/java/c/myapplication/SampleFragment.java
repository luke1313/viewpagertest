package c.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lukasolsen on 24/11/15.
 */
public class SampleFragment extends Fragment {

  private static final String ARG_PARAM1 = "param1";

  RecyclerView recyclerView;

  public SampleFragment() {
    // Required empty public constructor
  }

  public static SampleFragment newInstance(String param1) {
    SampleFragment fragment = new SampleFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);

    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View convertView = inflater.inflate(R.layout.fragment, container, false);
    //        tabText= (TextView) convertView.findViewById(R.id.tabText);
    //        tabText.setText("Tab Layout No "+mParam1);
    recyclerView = (RecyclerView) convertView.findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(new ListAdapter());

    return convertView;
  }

  class ListAdapter extends RecyclerView.Adapter {

    class ListViewHolder extends RecyclerView.ViewHolder {

      TextView text;

      public ListViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.textId);
      }

      public void bind(int position) {
        text.setText("Test " + position);
      }
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ListViewHolder(
          LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      ((ListViewHolder) holder).bind(position);
    }

    @Override public int getItemCount() {
      return 20;
    }
  }
}