/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.ml.database.internal.constants;

/**
 * A utility class to store SQL prepared statements
 */
public class SQLQueries {

    public static final String INSERT_DATASET_SCHEMA = "INSERT INTO ML_DATASET_SCHEMA(NAME, TENANT_ID, USERNAME, " +
            "COMMENTS, SOURCE_TYPE, TARGET_TYPE, DATA_TYPE) VALUES(?,?,?,?,?,?,?)";
    
    public static final String GET_ALL_VERSIONSETS_OF_DATASET = "SELECT DATASET_VERSION_ID, NAME, VERSION, URI, SAMPLE_POINTS" +
            " FROM ML_DATASET_VERSION  WHERE DATASET_SCHEMA_ID = ? AND TENANT_ID = ? AND USERNAME = ?";
    
    public static final String GET_VERSIONSET_USING_ID = "SELECT DATASET_VERSION_ID, NAME, URI, SAMPLE_POINTS FROM " +
            "ML_DATASET_VERSION WHERE DATASET_VERSION_ID = ? AND TENANT_ID = ? AND USERNAME = ?";
    
    public static final String GET_ALL_DATASETS = "SELECT DATASET_SCHEMA_ID, NAME, COMMENTS, SOURCE_TYPE, TARGET_TYPE" +
            ", DATA_TYPE FROM ML_DATASET_SCHEMA WHERE TENANT_ID = ? AND USERNAME = ?";
    
    public static final String GET_DATASET_USING_ID = "SELECT DATASET_SCHEMA_ID, NAME, COMMENTS, SOURCE_TYPE, " +
            "TARGET_TYPE, DATA_TYPE FROM ML_DATASET_SCHEMA WHERE TENANT_ID = ? AND USERNAME = ? AND DATASET_SCHEMA_ID = ?";
    
    public static final String GET_DATASET_ID_FROM_DATASET_VERSION = "SELECT DATASET_SCHEMA_ID FROM ML_DATASET_VERSION" +
            " WHERE DATASET_VERSION_ID = ?";
    
    public static final String UPDATE_SAMPLE_POINTS = "UPDATE ML_DATASET_VERSION SET SAMPLE_POINTS=? where DATASET_VERSION_ID=?";
    
    public static final String GET_DATASET_USING_NAME = "SELECT DATASET_ID , NAME, COMMENTS, SOURCE_TYPE, TARGET_TYPE, DATA_TYPE FROM ML_DATASET WHERE TENANT_ID = ? AND USERNAME = ? AND NAME=?";

    public static final String INSERT_FEATURE_DEFAULTS = "INSERT INTO ML_FEATURE_DEFAULTS(DATASET_SCHEMA_ID, FEATURE_NAME, TYPE, FEATURE_INDEX) "
            + "VALUES(?,?,?,?)";

    public static final String GET_FEATURE_ID = "SELECT FEATURE_ID FROM ML_FEATURE_DEFAULTS WHERE DATASET_SCHEMA_ID = ? AND FEATURE_NAME =?";

    public static final String INSERT_FEATURE_SUMMARY = "INSERT INTO ML_FEATURE_SUMMARY(FEATURE_ID, FEATURE_NAME, DATASET_VERSION_ID, " +
            "SUMMARY) VALUES(?, ?, ?, ?)";

    public static final String INSERT_DATASET_VERSION = "INSERT INTO ML_DATASET_VERSION(DATASET_SCHEMA_ID, NAME, VERSION, TENANT_ID, USERNAME, URI, SAMPLE_POINTS) "
            + "VALUES(?,?,?,?,?,?,?)";

    public static final String INSERT_DATA_SOURCE = "INSERT INTO ML_DATA_SOURCE(VALUE_SET_ID, TENANT_ID, USERNAME, KEY, VALUE) VALUES (?,?,?,?,?)";

    public static final String GET_DATASET_ID = "SELECT DATASET_SCHEMA_ID FROM ML_DATASET_SCHEMA WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ?";

    public static final String GET_DATASETVERSION_ID = "SELECT DATASET_VERSION_ID FROM ML_DATASET_VERSION WHERE DATASET_ID = ? AND TENANT_ID = ? AND USERNAME = ? AND VERSION = ?";

    public static final String GET_VERSIONSET_ID = "SELECT DATASET_VERSION_ID FROM ML_DATASET_VERSION WHERE NAME = ? AND TENANT_ID = ? ";

    public static final String GET_DATASET_SCHEMA_ID_FROM_ANALYSIS = "SELECT DATASET_SCHEMA_ID FROM ML_PROJECT INNER JOIN ML_ANALYSIS ON ML_PROJECT.PROJECT_ID = ML_ANALYSIS.PROJECT_ID WHERE ANALYSIS_ID=?";

    public static final String GET_DATASET_VERSION_ID = "SELECT DATASET_VERSION_ID FROM ML_DATASET_VERSION WHERE DATASET_ID = ? AND VERSION = ? ";

    public static final String GET_DATASET_VERSION = "SELECT ML_DATASET_VERSION.VERSION FROM ML_DATASET, ML_DATASET_VERSION "
            + "WHERE ML_DATASET.DATASET_ID = ML_DATASET_VERSION.DATASET_ID AND ML_DATASET.NAME = ? AND ML_DATASET.TENANT_ID = ? AND ML_DATASET_VERSION.VERSION = ?";

    public static final String GET_DATASET_VERSION_LOCATION = "SELECT URI FROM ML_DATASET_VERSION WHERE DATASET_VERSION_ID=?";

    public static final String GET_SAMPLE_POINTS = "SELECT SAMPLE_POINTS FROM ML_VALUE_SET WHERE VALUE_SET_ID=?";

    public static final String GET_FEATURE_COUNT = "SELECT COUNT(FEATURE_NAME) FROM ML_FEATURE_DEFAULTS WHERE DATASET_SCHEMA_ID =?";

    public static final String GET_DEFAULT_FEATURES = "SELECT FEATURE_NAME, SUMMARY, TYPE, FEATURE_INDEX FROM  ML_FEATURE_DEFAULTS  "
            + "WHERE  DATASET_VERSION_ID = ? LIMIT ? OFFSET ?";

    public static final String GET_CUSTOMIZED_FEATURES = "SELECT FEATURE_NAME,FEATURE_INDEX,FEATURE_TYPE, IMPUTE_OPTION, " +
            "INCLUSION FROM ML_FEATURE_CUSTOMIZED WHERE ANALYSIS_ID=?";

    public static final String GET_SUMMARY_STATS = "SELECT SUMMARY FROM ML_FEATURE_DEFAULTS WHERE FEATURE_NAME=? AND "
            + "DATASET_VERSION_ID=?";

    public static final String GET_FEATURE_TYPE = "SELECT  TYPE FROM ML_FEATURE_CUSTOMIZED  WHERE  MODEL_ID  =  ? AND "
            + "FEATURE_NAME = ?";

    public static final String GET_FEATURE_NAMES = "SELECT FEATURE_NAME FROM ML_FEATURE_CUSTOMIZED WHERE MODEL_ID=? AND "
            + "INCLUSION=TRUE";

    public static final String UPDATE_FEATURE_INCLUSION = "UPDATE  ML_FEATURE_CUSTOMIZED SET INCLUSION = ? WHERE "
            + "FEATURE_NAME=? AND MODEL_ID=?";

    public static final String UPDATE_IMPUTE_METHOD = "UPDATE  ML_FEATURE_CUSTOMIZED SET "
            + "IMPUTE_METHOD = ? WHERE FEATURE_NAME = ? AND MODEL_ID = ?";

    public static final String UPDATE_DATA_TYPE = "UPDATE ML_FEATURE_CUSTOMIZED SET TYPE =? WHERE FEATURE_NAME=? AND "
            + "MODEL_ID=?";

    public static final String INSERT_ANALYSIS = "INSERT INTO ML_ANALYSIS(PROJECT_ID, NAME, TENANT_ID, USERNAME, COMMENTS) VALUES(?,?,?,?,?)";

    public static final String INSERT_MODEL = "INSERT INTO ML_MODEL(NAME, ANALYSIS_ID, DATASET_VERSION_ID, TENANT_ID, USERNAME, CREATED_TIME) "
            + "VALUES(?,?,?,?,?, CURRENT_TIMESTAMP())";

    public static final String UPDATE_MODEL_SUMMARY = "UPDATE ML_MODEL SET SUMMARY=? where MODEL_ID=?";

    public static final String UPDATE_MODEL_STORAGE = "UPDATE ML_MODEL SET STORAGE_TYPE=?, STORAGE_LOCATION=? where MODEL_ID=?";

    public static final String INSERT_MODEL_CONFIGURATION = "INSERT INTO ML_MODEL_CONFIGURATION(ANALYSIS_ID, KEY, VALUE) "
            + "VALUES(?,?,?)";
    public static final String GET_A_MODEL_CONFIGURATION = "SELECT VALUE FROM ML_MODEL_CONFIGURATION WHERE ANALYSIS_ID = ? AND KEY = ?";

    public static final String INSERT_HYPER_PARAMETER = "INSERT INTO ML_HYPER_PARAMETER(ANALYSIS_ID, NAME, VALUE, LAST_MODIFIED_TIME) "
            + "VALUES(?,?,?, CURRENT_TIMESTAMP())";

    public static final String GET_HYPER_PARAMETERS_OF_ANALYSIS = "SELECT NAME, VALUE FROM ML_HYPER_PARAMETER WHERE ANALYSIS_ID=?";

    public static final String INSERT_FEATURE_CUSTOMIZED = "INSERT INTO ML_FEATURE_CUSTOMIZED(ANALYSIS_ID, TENANT_ID, FEATURE_NAME, FEATURE_TYPE, IMPUTE_OPTION, "
            + "INCLUSION, LAST_MODIFIED_USER, USERNAME, LAST_MODIFIED_TIME) VALUES(?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP())";

    public static final String INSERT_DEFAULTS_INTO_FEATURE_CUSTOMIZED = 
            "INSERT INTO ML_FEATURE_CUSTOMIZED(ANALYSIS_ID, TENANT_ID, FEATURE_NAME, FEATURE_INDEX, FEATURE_TYPE, IMPUTE_OPTION, INCLUSION, LAST_MODIFIED_USER, USERNAME, LAST_MODIFIED_TIME, FEATURE_ID) "
            + "SELECT ?, ?, FEATURE_NAME, FEATURE_INDEX, TYPE, ?, ?, ?, ?, CURRENT_TIMESTAMP(), FEATURE_ID FROM ML_FEATURE_DEFAULTS WHERE DATASET_SCHEMA_ID = ? ";

    public static final String GET_ANALYSIS_ID = "SELECT ANALYSIS_ID FROM ML_ANALYSIS WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ANALYSIS = "SELECT ANALYSIS_ID, PROJECT_ID, COMMENTS FROM ML_ANALYSIS WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ALL_ANALYSES = "SELECT ANALYSIS_ID, PROJECT_ID, COMMENTS, NAME FROM ML_ANALYSIS WHERE TENANT_ID = ? AND USERNAME = ?";
    
    public static final String GET_ALL_ANALYSES_OF_PROJECT = "SELECT ANALYSIS_ID, PROJECT_ID, COMMENTS, NAME FROM ML_ANALYSIS WHERE TENANT_ID = ? AND USERNAME = ? AND PROJECT_ID = ?";

    public static final String GET_ML_MODEL_ID = "SELECT MODEL_ID FROM ML_MODEL WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ML_MODEL = "SELECT MODEL_ID, ANALYSIS_ID, DATASET_VERSION_ID, CREATED_TIME, STORAGE_TYPE, STORAGE_LOCATION FROM ML_MODEL WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ML_MODEL_FROM_ID = "SELECT NAME, ANALYSIS_ID, DATASET_VERSION_ID, CREATED_TIME, STORAGE_TYPE, STORAGE_LOCATION FROM ML_MODEL WHERE MODEL_ID = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ALL_ML_MODELS = "SELECT MODEL_ID, ANALYSIS_ID, DATASET_VERSION_ID, CREATED_TIME, STORAGE_TYPE, STORAGE_LOCATION, NAME FROM ML_MODEL WHERE TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_DATA_TYPE_OF_MODEL = "SELECT ML_DATASET_SCHEMA.DATA_TYPE FROM ML_DATASET_SCHEMA INNER JOIN " +
            "(SELECT ML_DATASET_VERSION.DATASET_SCHEMA_ID as ID  FROM ML_DATASET_VERSION INNER JOIN " +
            "ML_MODEL ON ML_MODEL.DATASET_VERSION_ID = ML_DATASET_VERSION.DATASET_VERSION_ID WHERE ML_MODEL.MODEL_ID=?) " +
            "ON ID = ML_DATASET_SCHEMA.DATASET_SCHEMA_ID";

    public static final String SELECT_DATASET_VERSION_ID_OF_MODEL = "SELECT DATASET_VERSION_ID FROM ML_MODEL WHERE MODEL_ID=? ";

    public static final String GET_ML_MODEL_NAME = "SELECT NAME FROM ML_MODEL WHERE MODEL_ID = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String DELETE_ANALYSIS = "DELETE FROM ML_ANALYSIS WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_FEATURES = "SELECT  FEATURE_INDEX ,ML_FEATURE_CUSTOMIZED.FEATURE_NAME ,INCLUSION ,FEATURE_TYPE , "
            + "IMPUTE_OPTION, SUMMARY FROM ML_FEATURE_CUSTOMIZED INNER JOIN ML_FEATURE_SUMMARY ON ML_FEATURE_CUSTOMIZED.FEATURE_ID = ML_FEATURE_SUMMARY.FEATURE_ID "
            + "WHERE ANALYSIS_ID = ? AND ML_FEATURE_CUSTOMIZED.TENANT_ID = ? AND ML_FEATURE_CUSTOMIZED.USERNAME = ? LIMIT ? OFFSET ?";

    public static final String INSERT_PROJECT = "INSERT INTO ML_PROJECT(NAME, DESCRIPTION, DATASET_SCHEMA_ID, TENANT_ID,"
            + " USERNAME, CREATED_TIME) VALUES(?,?,?,?,?, CURRENT_TIMESTAMP())";

    public static final String GET_PROJECT_ID = "SELECT PROJECT_ID FROM ML_PROJECT WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ?";

    public static final String DELETE_PROJECT = "DELETE FROM ML_PROJECT WHERE NAME = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String DELETE_MODEL = "DELETE FROM ML_MODEL WHERE MODEL_ID = ? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_PROJECT = "SELECT PROJECT_ID ,DESCRIPTION, DATASET_SCHEMA_ID, CREATED_TIME FROM ML_PROJECT "
            + "WHERE NAME=? AND TENANT_ID = ? AND USERNAME = ? ";

    public static final String GET_ALL_PROJECTS = "SELECT NAME, PROJECT_ID ,DESCRIPTION, DATASET_SCHEMA_ID, CREATED_TIME FROM ML_PROJECT "
            + "WHERE TENANT_ID = ? AND USERNAME = ? ";

    public static final String ADD_TENANT_TO_PROJECT = "INSERT INTO ML_TENANT_PROJECTS (TENANT_ID, PROJECT_ID) "
            + "VALUES(?,?)";

    public static final String GET_MODEL_STORAGE = "SELECT STORAGE_TYPE, STORAGE_LOCATION FROM ML_MODEL WHERE MODEL_ID=?";

    /*
     * private Constructor to prevent any other class from instantiating.
     */
    private SQLQueries() {
    }
}
