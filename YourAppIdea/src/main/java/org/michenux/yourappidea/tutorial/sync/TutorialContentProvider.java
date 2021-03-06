package org.michenux.yourappidea.tutorial.sync;

import android.content.UriMatcher;
import android.net.Uri;

import org.michenux.drodrolib.content.ContentProviderUtils;
import org.michenux.drodrolib.db.AbstractContentProvider;
import org.michenux.yourappidea.BuildConfig;

public class TutorialContentProvider extends AbstractContentProvider {

    public static final String TABLE_NAME = "T_TUTORIAL" ;
    public static final String POSTID_COLUMN = "POSTID" ;
    public static final String TITLE_COLUMN = "TITLE";
    public static final String DESCRIPTION_COLUMN = "DESCRIPTION";
    public static final String URL_COLUMN = "URL";
    public static final String THUMBNAIL_COLMUN = "THUMBNAIL";
    public static final String AUTHOR_COLUMN = "AUTHOR";
    public static final String CONTENT_COLUMN = "CONTENT";
    public static final String DATECREATION_COLUMN = "DATECREATION";
    public static final String DATEMODIFICATION_COLUMN = "DATEMODIFICATION";

    public static final String AUTHORITY = ContentProviderUtils.buildAuthority(
            BuildConfig.APPLICATION_ID, BuildConfig.FLAVOR, "tutorials");

    private static final String BASE_PATH = "tutorial";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, LIST);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", ITEM_ID);
    }

    public TutorialContentProvider() {
        super(TABLE_NAME, uriMatcher, BASE_PATH );
    }
}
