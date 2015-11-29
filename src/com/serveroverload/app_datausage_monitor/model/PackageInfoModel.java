package com.serveroverload.app_datausage_monitor.model;

import android.content.pm.FeatureInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;

// TODO: Auto-generated Javadoc
/**
 * The Class PackageInfoModel.
 */
public class PackageInfoModel {

	/**
	 * Instantiates a new package info model.
	 *
	 * @param appName the app name
	 * @param packageName the package name
	 * @param versioName the versio name
	 * @param versionCode the version code
	 * @param icon the icon
	 * @param packageFeature the package feature
	 * @param packagePermission the package permission
	 */
	public PackageInfoModel(String appName, String packageName, String versioName,
			String versionCode, Drawable icon, FeatureInfo[] packageFeature,
			PermissionInfo[] packagePermission) {
		super();
		this.appName = appName;
		this.packageName = packageName;
		this.versioName = versioName;
		this.versionCode = versionCode;
		Icon = icon;
		this.packageFeature = packageFeature;
		this.packagePermission = packagePermission;
	}

	/**
	 * Gets the package feature.
	 *
	 * @return the package feature
	 */
	public FeatureInfo[] getPackageFeature() {
		return packageFeature;
	}

	/**
	 * Sets the package feature.
	 *
	 * @param packageFeature the new package feature
	 */
	public void setPackageFeature(FeatureInfo[] packageFeature) {
		this.packageFeature = packageFeature;
	}

	/**
	 * Gets the package permission.
	 *
	 * @return the package permission
	 */
	public PermissionInfo[] getPackagePermission() {
		return packagePermission;
	}

	/**
	 * Sets the package permission.
	 *
	 * @param packagePermission the new package permission
	 */
	public void setPackagePermission(PermissionInfo[] packagePermission) {
		this.packagePermission = packagePermission;
	}

	/** The version code. */
	private String appName, packageName, versioName, versionCode;

	/** The package feature. */
	FeatureInfo[] packageFeature;
	
	/** The package permission. */
	PermissionInfo[] packagePermission;

	/**
	 * Gets the app name.
	 *
	 * @return the app name
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * Sets the app name.
	 *
	 * @param appName the new app name
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * Gets the package name.
	 *
	 * @return the package name
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Sets the package name.
	 *
	 * @param packageName the new package name
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * Gets the versio name.
	 *
	 * @return the versio name
	 */
	public String getVersioName() {
		return versioName;
	}

	/**
	 * Sets the versio name.
	 *
	 * @param versioName the new versio name
	 */
	public void setVersioName(String versioName) {
		this.versioName = versioName;
	}

	/**
	 * Gets the version code.
	 *
	 * @return the version code
	 */
	public String getVersionCode() {
		return versionCode;
	}

	/**
	 * Sets the version code.
	 *
	 * @param versionCode the new version code
	 */
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public Drawable getIcon() {
		return Icon;
	}

	/** The Icon. */
	Drawable Icon;

	/**
	 * Sets the appname.
	 *
	 * @param string the new appname
	 */
	public void setAppname(String string) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the pname.
	 *
	 * @param packageName the new pname
	 */
	public void setPname(String packageName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the version name.
	 *
	 * @param versionName the new version name
	 */
	public void setVersionName(String versionName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the version code.
	 *
	 * @param versionCode the new version code
	 */
	public void setVersionCode(int versionCode) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the icon.
	 *
	 * @param loadIcon the new icon
	 */
	public void setIcon(Drawable loadIcon) {
		// TODO Auto-generated method stub

	}

}
