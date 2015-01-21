package io.bitfountain.matthewparker.shutterdroid.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matthewparker on 1/20/15.
 */
public class Image {
    @SerializedName("id")
    private String mId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("assets")
    private ImageAssets mAssets;

    public String getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLargeThumbnail(){
        return mAssets.mLargeThumb.mUrl;
    }

    private class ImageAssets{
        @SerializedName("preview")
        private Thumbnail mPreview;

        @SerializedName("small_thumb")
        private Thumbnail mSmallThumb;

        @SerializedName("large_thumb")
        private Thumbnail mLargeThumb;
    }

    private class Thumbnail{
        @SerializedName("url")
        private String mUrl;
    }
}
