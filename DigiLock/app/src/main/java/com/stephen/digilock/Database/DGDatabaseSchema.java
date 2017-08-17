package com.stephen.digilock.Database;

import android.provider.BaseColumns;

/**
 * Created by stephen on 07/08/2017.
 */

/*

Check to see if the database already exists

If it does not, create it and create the tables and initial data it needs

If it does, open it up and see what version of your database it has

If it is an old version, run code to upgrade it to a newer version

 */

public class DGDatabaseSchema {

    public static final class MakerTable {
        public static final String MAKER = "KeyMaker";

        public static final class MakerCols {
            public static final String ID = "Id";
            public static final String SECRET = "Secret";
        }
    }

    public static final class FeatureTable {
        public static final String FEATURE = "Feature";

        public static final class FeatureCols {
            public static final String ID = "Id";
            public static final String MAKER_ID = "MakerId";
            public static final String FEATURE_NAME = "FeatureName";
            public static final String FEATURE_ITEM = "FeatureItem";
        }
    }

    public static final class CutTable {
        public static final String CUT = "Cut";

        public static final class CutCols {
            public static final String ID = "Id";
            public static final String MAKER_ID = "MakerId";
        }
    }

    public static final class RuleTable {
        public static final String RULE = "Rule";

        public static final class RuleCols {
            public static final String ID = "Id";
            public static final String CUT_ID = "CutId";
            public static final String BASE = "Base";
            public static final String MODIFIER = "Modifier";
        }
    }

    public static final class BowTable {
        public static final String BOW = "Bow";

        public static final class BowCols {
            public static final String ID = "Id";
            public static final String SHOULDER = "Shoulder";
        }
    }

    public static final class KeyTable {
        public static final String KEY = "Key";

        public static final class KeyCols {
            public static final String ID = "Id";
            public static final String BOW_ID = "BowId";
            public static final String CUT_ID = "CutId";
        }
    }

}
