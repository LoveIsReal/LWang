package com.example.customloadingview;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2016/1/26.
 */
public class PointAndSizeEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PointAndSizeOfEyes point_start = (PointAndSizeOfEyes) startValue;
        PointAndSizeOfEyes point_end = (PointAndSizeOfEyes) endValue;

        //  需要注意的是    平移后的坐标X 还是 Y 都是变小的   所以  endValue < startValue
        return new PointAndSizeOfEyes(point_start.getX() - (point_start.getX() - point_end.getX()) * fraction, point_start.getY() -
                (point_start.getY() - point_end.getY()) * fraction, point_start.getEyeRadius() + fraction * (point_end.getEyeRadius() - point_start.getEyeRadius()));
    }

}
