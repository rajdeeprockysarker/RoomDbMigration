# RoomDbMigration

app.gradle : 
--------------------

    def work_version = "2.3.4"
    implementation "androidx.work:work-runtime-ktx:$work_version"


    implementation 'androidx.room:room-runtime:2.2.5'
    kapt 'androidx.room:room-compiler:2.2.5'
    
    
 User Table (user_basic_info) add collum
 ----------------------
 
     @Bindable
    @ColumnInfo(name = "migration_colum")
    var migration_colum = 0
    
 App database change version 2 to 3
 ----------------------
 
         val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user_basic_info ADD COLUMN migration_colum INTEGER NOT NULL DEFAULT 0")
            }
        }
        
        ...
        
        .addMigrations(MIGRATION_2_3)
        

        
        
        
