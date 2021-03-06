package com.fotile.recipe.uitl.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.fotile.recipe.bean.recipe.DAIngredient;
import com.fotile.recipe.bean.recipe.DBIngredient;
import com.fotile.recipe.bean.recipe.DCIngredient;
import com.fotile.recipe.bean.recipe.DCookingPromptsInfo;
import com.fotile.recipe.bean.recipe.DCookingStep;
import com.fotile.recipe.bean.recipe.DDIngredient;
import com.fotile.recipe.bean.recipe.DDevice;
import com.fotile.recipe.bean.recipe.DMajorIngredient;
import com.fotile.recipe.bean.recipe.DMinorIngredient;
import com.fotile.recipe.bean.recipe.DProducts;
import com.fotile.recipe.bean.recipe.DPromptContent;
import com.fotile.recipe.bean.recipe.DProperties;
import com.fotile.recipe.bean.recipe.DReadyStep;
import com.fotile.recipe.bean.recipe.DRecipe;
import com.fotile.recipe.bean.recipe.DRecipeBanner;
import com.fotile.recipe.greendao.DAIngredientDao;
import com.fotile.recipe.greendao.DBIngredientDao;
import com.fotile.recipe.greendao.DCIngredientDao;
import com.fotile.recipe.greendao.DCookingPromptsInfoDao;
import com.fotile.recipe.greendao.DCookingStepDao;
import com.fotile.recipe.greendao.DDIngredientDao;
import com.fotile.recipe.greendao.DDeviceDao;
import com.fotile.recipe.greendao.DMajorIngredientDao;
import com.fotile.recipe.greendao.DMinorIngredientDao;
import com.fotile.recipe.greendao.DProductsDao;
import com.fotile.recipe.greendao.DPromptContentDao;
import com.fotile.recipe.greendao.DPropertiesDao;
import com.fotile.recipe.greendao.DReadyStepDao;
import com.fotile.recipe.greendao.DRecipeBannerDao;
import com.fotile.recipe.greendao.DRecipeDao;
import com.fotile.recipe.greendao.DaoMaster;
import com.fotile.recipe.greendao.DaoSession;
import com.fotile.recipe.uitl.RecipeConstant;

import org.greenrobot.greendao.rx.RxQuery;

import java.util.List;

/**
 * 文件名称：RecipeFavoriteDaoManager
 * 创建时间：2017-09-04 18:20
 * 文件作者：shihuijuan
 * 功能描述：我的收藏数据库操作类
 */

public class RecipeFavoriteDaoManager {
    private Context context;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DRecipeDao dRecipeDao;
    private DDeviceDao dDeviceDao;
    private DCookingPromptsInfoDao dCookingPromptsInfoDao;
    private DPromptContentDao dPromptContentDao;
    private DProductsDao dProductsDao;
    private DPropertiesDao dPropertiesDao;
    private DCookingStepDao dCookingStepDao;
    private DReadyStepDao dReadyStepDao;
    private DDIngredientDao dDIngredientDao;
    private DCIngredientDao dCIngredientDao;
    private DBIngredientDao dBIngredientDao;
    private DAIngredientDao dAIngredientDao;
    private DMinorIngredientDao dMinorIngredientDao;
    private DMajorIngredientDao dMajorIngredientDao;
    private DRecipeBannerDao dRecipeBannerDao;


    public RecipeFavoriteDaoManager(Context context) {
        this.context = context;
        initDatabase();
    }

    /**
     * 初始化数据库
     */
    private void initDatabase() {
        devOpenHelper = new DaoMaster.DevOpenHelper(context, RecipeConstant.DB_FAVORITE_RECIPE, null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        dRecipeDao = daoSession.getDRecipeDao();
        dDeviceDao = daoSession.getDDeviceDao();
        dCookingPromptsInfoDao = daoSession.getDCookingPromptsInfoDao();
        dPromptContentDao = daoSession.getDPromptContentDao();
        dProductsDao = daoSession.getDProductsDao();
        dPropertiesDao = daoSession.getDPropertiesDao();
        dCookingStepDao = daoSession.getDCookingStepDao();
        dReadyStepDao = daoSession.getDReadyStepDao();
        dDIngredientDao = daoSession.getDDIngredientDao();
        dCIngredientDao = daoSession.getDCIngredientDao();
        dBIngredientDao = daoSession.getDBIngredientDao();
        dAIngredientDao = daoSession.getDAIngredientDao();
        dMinorIngredientDao = daoSession.getDMinorIngredientDao();
        dMajorIngredientDao = daoSession.getDMajorIngredientDao();
        dRecipeBannerDao = daoSession.getDRecipeBannerDao();
    }


    /**
     * 插入菜谱
     *
     * @param recipe
     * @return
     */
    public long insert(DRecipe recipe) {
        if (null != recipe && null != dRecipeDao) {
            return dRecipeDao.insertOrReplace(recipe);
        } else {
            return -1;
        }
    }

    /**
     * 插入菜谱特性,比如难易程度
     *
     * @param properties
     */
    public void insert(DProperties properties) {
        if (null != properties && null != dPropertiesDao) {
            dPropertiesDao.insertOrReplace(properties);
        }
    }

    /**
     * 插入设备信息
     *
     * @param dDevice
     */
    public void insert(DDevice dDevice) {
        if (null != dDevice && null != dDeviceDao) {
            dDeviceDao.insertOrReplace(dDevice);
        }
    }

    /**
     * 插入产品信息
     *
     * @param dProducts
     */
    public void insert(DProducts dProducts) {
        if (null != dProducts && null != dProductsDao) {
            dProductsDao.insertOrReplace(dProducts);
        }
    }

    /**
     * 插入烹饪提示信息
     *
     * @param dCookingPromptsInfo
     */
    public void insert(DCookingPromptsInfo dCookingPromptsInfo) {
        if (null != dCookingPromptsInfo && null != dCookingPromptsInfoDao) {
            dCookingPromptsInfoDao.insertOrReplace(dCookingPromptsInfo);
        }
    }

    /**
     * 插入提示内容
     *
     * @param dPromptContent
     */
    public void insert(DPromptContent dPromptContent) {
        if (null != dPromptContent && null != dPromptContentDao) {
            dPromptContentDao.insertOrReplace(dPromptContent);
        }
    }

    /**
     * 插入菜谱步骤
     *
     * @param cookingStep
     */
    public void insert(DCookingStep cookingStep) {
        if (null != cookingStep && null != dCookingStepDao) {
            dCookingStepDao.insertOrReplace(cookingStep);
        }
    }

    /**
     * 插入菜谱准备步骤
     *
     * @param readyStep
     */
    public void insert(DReadyStep readyStep) {
        if (null != readyStep && null != dReadyStepDao) {
            dReadyStepDao.insertOrReplace(readyStep);
        }
    }

    /**
     * 插入D配料
     *
     * @param ddIngredient
     */
    public void insert(DDIngredient ddIngredient) {
        if (null != ddIngredient && null != dDIngredientDao) {
            dDIngredientDao.insertOrReplace(ddIngredient);
        }
    }

    /**
     * 插入C配料
     *
     * @param dcIngredient
     */
    public void insert(DCIngredient dcIngredient) {
        if (null != dcIngredient && null != dCIngredientDao) {
            dCIngredientDao.insertOrReplace(dcIngredient);
        }
    }

    /**
     * 插入B配料
     *
     * @param dbIngredient
     */
    public void insert(DBIngredient dbIngredient) {
        if (null != dbIngredient && null != dBIngredientDao) {
            dBIngredientDao.insertOrReplace(dbIngredient);
        }
    }

    /**
     * 插入A配料
     *
     * @param daIngredient
     */
    public void insert(DAIngredient daIngredient) {
        if (null != daIngredient && null != dAIngredientDao) {
            dAIngredientDao.insertOrReplace(daIngredient);
        }
    }

    /**
     * 插入辅料
     *
     * @param minorIngredient
     */
    public void insert(DMinorIngredient minorIngredient) {
        if (null != minorIngredient && null != dMinorIngredientDao) {
            dMinorIngredientDao.insertOrReplace(minorIngredient);
        }
    }

    /**
     * 插入主料
     *
     * @param dMajorIngredient
     */
    public void insert(DMajorIngredient dMajorIngredient) {
        if (null != dMajorIngredient && null != dMajorIngredientDao) {
            dMajorIngredientDao.insertOrReplace(dMajorIngredient);
        }
    }

    /**
     * 根据id查询菜谱(未使用RX JAVA写法)
     *
     * @param recipeId
     * @return
     */
    public DRecipe queryRecipeByRecipeId(String recipeId) {
        DRecipe dRecipe = dRecipeDao.queryBuilder().where(DRecipeDao.Properties.Id.eq(recipeId)).unique();
        return dRecipe;
    }

    /**
     * 根据Id查询菜谱(使用RX JAVA写法)
     *
     * @param recipeId
     * @return
     */
    public RxQuery<DRecipe> queryRecipeByRecipeIdRX(String recipeId) {
        return dRecipeDao.queryBuilder().where(DRecipeDao.Properties.Id.eq(recipeId)).rx();
    }

    /**
     * 查询菜谱列表
     *
     * @return
     */
    public RxQuery<DRecipe> queryAll() {
        return dRecipeDao.queryBuilder().rx();
    }

    /**
     * 查询菜谱数量
     *
     * @return
     */
    public int getMyFavoriteSize() {
        List<DRecipe> list = dRecipeDao.queryBuilder().list();
        return  list == null ? 0 : list.size();
    }
    /**
     * 根据id删除菜谱
     *
     * @param recipeId
     */
    public void deleteByRecipeId(String recipeId) {
        daoSession.getDatabase().beginTransaction();
        try {
            dRecipeDao.queryBuilder().where(DRecipeDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dDeviceDao.queryBuilder().where(DDeviceDao.Properties.RecipeId.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dPropertiesDao.queryBuilder().where(DPropertiesDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dCookingStepDao.queryBuilder().where(DCookingStepDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dReadyStepDao.queryBuilder().where(DReadyStepDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dCookingPromptsInfoDao.queryBuilder().where(DCookingPromptsInfoDao.Properties.RecipeId.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dProductsDao.queryBuilder().where(DProductsDao.Properties.RecipeId.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dPromptContentDao.queryBuilder().where(DPromptContentDao.Properties.RecipeId.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dDIngredientDao.queryBuilder().where(DDIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dCIngredientDao.queryBuilder().where(DCIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dBIngredientDao.queryBuilder().where(DBIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dAIngredientDao.queryBuilder().where(DAIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dMajorIngredientDao.queryBuilder().where(DMajorIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dMinorIngredientDao.queryBuilder().where(DMinorIngredientDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            dRecipeBannerDao.queryBuilder().where(DRecipeBannerDao.Properties.Id.eq(recipeId)).buildDelete().executeDeleteWithoutDetachingEntities();
            daoSession.getDatabase().setTransactionSuccessful();
        } finally {
            daoSession.getDatabase().endTransaction();
        }
    }

    /**
     * 查询RecipeBanner
     *
     * @return
     */
    public DRecipeBanner queryRecipeBanner(String recipeId) {
        return dRecipeBannerDao.queryBuilder().where(DRecipeBannerDao.Properties.RecipeId.eq(recipeId)).unique();

    }


    /**
     * 插入轮播菜谱广告位数据
     *
     * @param list
     */
    public void insertRecipeBanner(List<DRecipeBanner> list) {
        dRecipeBannerDao.insertOrReplaceInTx(list);
    }

    /**
     * 查询菜谱名为name的菜谱
     *
     * @param name
     * @return
     */
    public RxQuery<DRecipe> queryRecipeBySearchKey(String name) {
        return dRecipeDao.queryBuilder().where(DRecipeDao.Properties.Name.like("%" + name + "%"), DRecipeDao.Properties.Source.eq("3")).rx();
    }
}
