package com.serveroverload.app_datausage_monitor.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.serveroverload.app_datausage_monitor.R;
import com.serveroverload.app_datausage_monitor.model.ComplexProcessesListArrayAdapter;
import com.serveroverload.app_datausage_monitor.model.ProcessesListArrayAdapter;
import com.serveroverload.app_datausage_monitor.model.ProcessesMonitor;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessListFragment.
 */
public class ProcessListFragment extends Fragment implements OnRefreshListener {

	/** The swipe layout. */
	private SwipeRefreshLayout swipeLayout;

	/** The mobile data toggle. */
	private ToggleButton mobileDataToggle;

	private ToggleButton detailToggler;

	private ProcessesMonitor processesMonitor;

	private boolean SHOW_DETAIL, SHOW_ONLY_USER_APP;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.frag_process_list, container,
				false);

		swipeLayout = (SwipeRefreshLayout) rootView
				.findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(ProcessListFragment.this);
		swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
				R.color.holo_green_light, R.color.holo_orange_light,
				R.color.holo_red_light);

		final ListView procesList = (ListView) rootView
				.findViewById(R.id.process_list);

		processesMonitor = new ProcessesMonitor(getActivity());

		mobileDataToggle = ((ToggleButton) rootView
				.findViewById(R.id.togle_processes));

		SHOW_ONLY_USER_APP = mobileDataToggle.isChecked();

		detailToggler = ((ToggleButton) rootView
				.findViewById(R.id.togle_detail));

		SHOW_DETAIL = detailToggler.isChecked();

		mobileDataToggle
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						SHOW_ONLY_USER_APP = isChecked;

						if (isChecked) {
							Toast.makeText(getActivity(),
									"Showing Only User Apps", 500).show();

						} else {
							Toast.makeText(getActivity(), "Showing All Apps",
									500).show();

						}

						procesList.setAdapter(new ProcessesListArrayAdapter(
								getActivity(), R.layout.process_list_item,
								processesMonitor
										.getRunningApplications(isChecked)));

					}
				});

		detailToggler.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {

				SHOW_DETAIL = isChecked;

				if (isChecked) {
					Toast.makeText(getActivity(), "Showing Details", 500)
							.show();

					procesList.setAdapter(new ComplexProcessesListArrayAdapter(
							getActivity(), R.layout.process_list_item,
							processesMonitor.showMoreDetail(SHOW_ONLY_USER_APP)));

				} else {
					Toast.makeText(getActivity(), "Showing Basic", 500).show();

					procesList.setAdapter(new ProcessesListArrayAdapter(
							getActivity(), R.layout.process_list_item,
							processesMonitor
									.getRunningApplications(SHOW_ONLY_USER_APP)));

				}

			}
		});

		procesList.setAdapter(new ProcessesListArrayAdapter(getActivity(),
				R.layout.process_list_item, new ProcessesMonitor(getActivity())
						.getRunningApplications(false)));

		return rootView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onPause()
	 */
	public void onPause() {
		super.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	public void onResume() {
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener#onRefresh
	 * ()
	 */
	@Override
	public void onRefresh() {

		swipeLayout.setRefreshing(false);

	}

}
