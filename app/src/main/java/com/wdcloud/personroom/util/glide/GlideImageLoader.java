package com.wdcloud.personroom.util.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import androidx.annotation.Nullable;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/15 14:04
 */
public class GlideImageLoader {
    //普通使用
    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    //设置占位图
    public static void loadPlaceHolder(Context context, String url, ImageView imageView, int loadingResId, int errorResId) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(loadingResId) //设置“加载中”状态时显示的图片
                .error(errorResId); //设置“加载失败”状态时显示的图片
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    /**
     * DiskCacheStrategy.NONE：表示不缓存任何内容。
     * DiskCacheStrategy.DATA：表示只缓存原始图片。
     * DiskCacheStrategy.RESOURCE：表示只缓存转换过后的图片。
     * DiskCacheStrategy.ALL ：表示既缓存原始图片，也缓存转换过后的图片。
     * DiskCacheStrategy.AUTOMATIC：表示让Glide根据图片资源智能地选择使用哪一种缓存策略
     */
    public static void loadDiskCache(Context context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true) //不加入内存缓存，默认会加入
                .diskCacheStrategy(DiskCacheStrategy.NONE); //不加入磁盘缓存
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
    //加载监听
    public static void loadProgress(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        //加载失败
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        //加载成功，resource为加载到的图片
                        //如果return true，则不会再回调Target的onResourceReady（也就是不再往下传递），imageView也就不会显示加载到的图片了。
                        return false;
                    }
                }).into(imageView);
    }
    //设置图片大小
    public static void loadImageSize(Context context,String url,ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.override(300, 200); //指定大小为300*200，无视imageView大小
        //requestOptions.override(Target.SIZE_ORIGINAL); //指定大小为图片原始大小，有更高OOM风险
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
    //圆角半径
    public static void loadRoundImage(Context context,String url,ImageView imageView){
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20))) //圆角半径  50为圆角矩形
                .into(imageView);
    }
    //圆图
    public static void loadCircleImage(Context context,String url,ImageView imageView){
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
