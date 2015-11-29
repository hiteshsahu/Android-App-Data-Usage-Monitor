package com.serveroverload.app_datausage_monitor.model;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class Processes.
 */
public class ProcessesMonitor {

	/**
	 * Instantiates a new processes.
	 *
	 * @param context the context
	 */
	public ProcessesMonitor(Context context) {
		super();
		this.context = context;
	}

	/** The context. */
	Context context;

	/**
	 * Gets the running applications.
	 *
	 * @param showUserApps the show user apps
	 * @return the running applications
	 */
	public List<RunningAppProcessInfo> getRunningApplications(
			boolean showUserApps) {
		// Get running processes
		ActivityManager manager = (ActivityManager) context
				.getSystemService(context.ACTIVITY_SERVICE);

		List<RunningAppProcessInfo> runningProcesses = manager
				.getRunningAppProcesses();

		if (runningProcesses != null && runningProcesses.size() > 0) {
			// Set data to the list adapter

			if (showUserApps) {

				List<RunningAppProcessInfo> userProcess = new ArrayList<ActivityManager.RunningAppProcessInfo>();

				for (RunningAppProcessInfo runningAppProcessInfo : runningProcesses) {

					try {
						ApplicationInfo app = context.getPackageManager()
								.getApplicationInfo(
										runningAppProcessInfo.processName, 0);

						if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 1) {
							// it's a system app, not interested

						} else if ((app.flags & ApplicationInfo.FLAG_SYSTEM) == 1) {
							// Discard this one
							// in this case, it should be a user-installed app

						} else {
							// Only User Apps shown
							userProcess.add(runningAppProcessInfo);
						}

					} catch (NameNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				return userProcess;
			} else {
				return runningProcesses;
			}

		} else {
			// In case there are no processes running (not a chance :))
			Toast.makeText(context, "No application is running",
					Toast.LENGTH_LONG).show();

			return runningProcesses;
		}

	}

	/**
	 * Gets the installed apps.
	 *
	 * @param getSysPackages the get sys packages
	 * @return the installed apps
	 */
	private ArrayList<PackageInfoModel> getInstalledApps(boolean getSysPackages) {
		ArrayList<PackageInfoModel> res = new ArrayList<PackageInfoModel>();

		List<PackageInfo> installedPackages = context.getPackageManager()
				.getInstalledPackages(0);

		for (int i = 0; i < installedPackages.size(); i++) {
			PackageInfo packageInfo = installedPackages.get(i);
			if ((!getSysPackages) && (packageInfo.versionName == null)) {
				continue;
			}

			FeatureInfo[] packageFeature = packageInfo.reqFeatures;
			PermissionInfo[] packagePermission = packageInfo.permissions;

			PackageInfoModel newInfo = new PackageInfoModel(
					packageInfo.applicationInfo.loadLabel(
							context.getPackageManager()).toString(),
					packageInfo.packageName, packageInfo.versionName,
					String.valueOf(packageInfo.versionCode),
					packageInfo.applicationInfo.loadIcon(context
							.getPackageManager()), packageFeature,
					packagePermission);

			res.add(newInfo);
		}
		return res;
	}

}
