package com.serveroverload.app_datausage_monitor.model;

import java.util.List;

import com.serveroverload.app_datausage_monitor.R;
import com.serveroverload.app_datausage_monitor.R.id;
import com.serveroverload.app_datausage_monitor.R.layout;

import android.annotation.SuppressLint;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductListArrayAdapter.
 */
public class ComplexProcessesListArrayAdapter extends
		ArrayAdapter<PackageInfoModel>

{

	/**
	 * Instantiates a new product list array adapter.
	 *
	 * @param context
	 *            the context
	 * @param resource
	 *            the resource
	 * @param mScanResults
	 *            the list of recordings
	 */
	public ComplexProcessesListArrayAdapter(Context context, int resource,
			List<PackageInfoModel> mScanResults) {
		super(context, resource, mScanResults);
		this.context = context;
		this.listOfProducts = mScanResults;
	}

	/** The context. */
	private final Context context;

	/** The list of recordings. */
	private final List<PackageInfoModel> listOfProducts;

	/**
	 * The Class ViewHolder.
	 */
	private class ViewHolder {

		ImageView appIcon;
		TextView appPackage, UID, sent, recieved, appName, permission,
				versionCode, feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@SuppressLint("NewApi")
	@Override
	public View getView(final int productIndex, View convertView,
			ViewGroup parent) {

		/** The holder. */
		final ViewHolder holder;

		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = inflater.inflate(R.layout.complex_process_list_item,
					parent, false);

			holder = new ViewHolder();

			holder.appPackage = (TextView) convertView
					.findViewById(R.id.app_package_name);

			holder.appIcon = (ImageView) convertView
					.findViewById(R.id.app_icon);

			holder.UID = (TextView) convertView.findViewById(R.id.UID);

			holder.sent = (TextView) convertView.findViewById(R.id.send);

			holder.recieved = (TextView) convertView
					.findViewById(R.id.recieved);

			holder.versionCode = (TextView) convertView
					.findViewById(R.id.app_version);

			holder.appName = (TextView) convertView.findViewById(R.id.app_name);

			holder.feature = (TextView) convertView
					.findViewById(R.id.app_features);

			holder.permission = (TextView) convertView
					.findViewById(R.id.app_permission);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.appPackage.setText("Package : "
				+ listOfProducts.get(productIndex).getPackageName());

		holder.versionCode.setText("Version : "
				+ listOfProducts.get(productIndex).getVersioName() + "_"
				+ listOfProducts.get(productIndex).getVersionCode());

		holder.UID
				.setText("UID : " + listOfProducts.get(productIndex).getUID());

		holder.appName.setText("App Name : "
				+ listOfProducts.get(productIndex).getAppName());

		if (null != listOfProducts.get(productIndex).getPackagePermission())
			holder.permission.setText("Permission : "
					+ listOfProducts.get(productIndex).getPackagePermission()
							.toString());

		if (null != listOfProducts.get(productIndex).getPackageFeature())
			holder.permission.setText("Features : "
					+ listOfProducts.get(productIndex).getPackageFeature()
							.toString());

		holder.appIcon.setImageDrawable(listOfProducts.get(productIndex)
				.getIcon());

		holder.sent.setText("Sent : "
				+ bytesHoomanRedable(
						TrafficStats.getUidTxBytes(listOfProducts.get(
								productIndex).getUID()), true));

		holder.recieved.setText("Recieve : "
				+ bytesHoomanRedable(
						TrafficStats.getUidRxBytes(listOfProducts.get(
								productIndex).getUID()), true));

		holder.sent.setSelected(true);

		holder.recieved.setSelected(true);

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//
//				Intent intent = new Intent(Intent.ACTION_DELETE, Uri
//						.parse("package:"
//								+ listOfProducts.get(productIndex)
//										.getPackageName()));
//				// intent.setData(Uri.parse(listOfProducts.get(productIndex).getPackageName()));
//				context.startActivity(intent);

			}
		});

		return convertView;

	}

	/**
	 * Bytes hooman redable.
	 *
	 * @param bytes
	 *            the bytes
	 * @param showInByte
	 *            the show in byte
	 * @return the string
	 */
	public static String bytesHoomanRedable(long bytes, boolean showInByte) {

		if (!showInByte) {
			long bits = bytes * 8;

			long Kbit = 1024;
			long Mbit = Kbit * 1024;
			long Gbit = Mbit * 1024;

			if (bits < Kbit)
				return String.valueOf(bits) + " bit";
			if (bits > Kbit && bits < Mbit)
				return String.valueOf(bits / Kbit) + " Kilobit";
			if (bits > Mbit && bits < Gbit)
				return String.valueOf(bits / Mbit) + " Megabit";
			if (bits > Gbit)
				return String.valueOf(bits / Gbit) + " Gigabit";
			return "???";
		} else {

			long bits = bytes;

			long Kbit = 1024;
			long Mbit = Kbit * 1024;
			long Gbit = Mbit * 1024;

			if (bits < Kbit)
				return String.valueOf(bits) + " Byte";
			if (bits > Kbit && bits < Mbit)
				return String.valueOf(bits / Kbit) + " KiloByte";
			if (bits > Mbit && bits < Gbit)
				return String.valueOf(bits / Mbit) + " MegaByte";
			if (bits > Gbit)
				return String.valueOf(bits / Gbit) + " GigaByte";
			return "???";

		}
	}
}
