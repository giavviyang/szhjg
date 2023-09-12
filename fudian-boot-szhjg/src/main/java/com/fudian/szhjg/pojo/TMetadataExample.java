package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMetadataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMetadataExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNull() {
            addCriterion("metadata_name is null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNotNull() {
            addCriterion("metadata_name is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameEqualTo(String value) {
            addCriterion("metadata_name =", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotEqualTo(String value) {
            addCriterion("metadata_name <>", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThan(String value) {
            addCriterion("metadata_name >", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_name >=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThan(String value) {
            addCriterion("metadata_name <", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThanOrEqualTo(String value) {
            addCriterion("metadata_name <=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLike(String value) {
            addCriterion("metadata_name like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotLike(String value) {
            addCriterion("metadata_name not like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIn(List<String> values) {
            addCriterion("metadata_name in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotIn(List<String> values) {
            addCriterion("metadata_name not in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameBetween(String value1, String value2) {
            addCriterion("metadata_name between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotBetween(String value1, String value2) {
            addCriterion("metadata_name not between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseIsNull() {
            addCriterion("metadata_chinese is null");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseIsNotNull() {
            addCriterion("metadata_chinese is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseEqualTo(String value) {
            addCriterion("metadata_chinese =", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseNotEqualTo(String value) {
            addCriterion("metadata_chinese <>", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseGreaterThan(String value) {
            addCriterion("metadata_chinese >", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_chinese >=", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseLessThan(String value) {
            addCriterion("metadata_chinese <", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseLessThanOrEqualTo(String value) {
            addCriterion("metadata_chinese <=", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseLike(String value) {
            addCriterion("metadata_chinese like", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseNotLike(String value) {
            addCriterion("metadata_chinese not like", value, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseIn(List<String> values) {
            addCriterion("metadata_chinese in", values, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseNotIn(List<String> values) {
            addCriterion("metadata_chinese not in", values, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseBetween(String value1, String value2) {
            addCriterion("metadata_chinese between", value1, value2, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataChineseNotBetween(String value1, String value2) {
            addCriterion("metadata_chinese not between", value1, value2, "metadataChinese");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIsNull() {
            addCriterion("metadata_type is null");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIsNotNull() {
            addCriterion("metadata_type is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeEqualTo(String value) {
            addCriterion("metadata_type =", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotEqualTo(String value) {
            addCriterion("metadata_type <>", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeGreaterThan(String value) {
            addCriterion("metadata_type >", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_type >=", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLessThan(String value) {
            addCriterion("metadata_type <", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLessThanOrEqualTo(String value) {
            addCriterion("metadata_type <=", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLike(String value) {
            addCriterion("metadata_type like", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotLike(String value) {
            addCriterion("metadata_type not like", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIn(List<String> values) {
            addCriterion("metadata_type in", values, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotIn(List<String> values) {
            addCriterion("metadata_type not in", values, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeBetween(String value1, String value2) {
            addCriterion("metadata_type between", value1, value2, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotBetween(String value1, String value2) {
            addCriterion("metadata_type not between", value1, value2, "metadataType");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldIsNull() {
            addCriterion("default_field is null");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldIsNotNull() {
            addCriterion("default_field is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldEqualTo(String value) {
            addCriterion("default_field =", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldNotEqualTo(String value) {
            addCriterion("default_field <>", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldGreaterThan(String value) {
            addCriterion("default_field >", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldGreaterThanOrEqualTo(String value) {
            addCriterion("default_field >=", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldLessThan(String value) {
            addCriterion("default_field <", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldLessThanOrEqualTo(String value) {
            addCriterion("default_field <=", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldLike(String value) {
            addCriterion("default_field like", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldNotLike(String value) {
            addCriterion("default_field not like", value, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldIn(List<String> values) {
            addCriterion("default_field in", values, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldNotIn(List<String> values) {
            addCriterion("default_field not in", values, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldBetween(String value1, String value2) {
            addCriterion("default_field between", value1, value2, "defaultField");
            return (Criteria) this;
        }

        public Criteria andDefaultFieldNotBetween(String value1, String value2) {
            addCriterion("default_field not between", value1, value2, "defaultField");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIsNull() {
            addCriterion("is_not_null is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIsNotNull() {
            addCriterion("is_not_null is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotNullEqualTo(String value) {
            addCriterion("is_not_null =", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotEqualTo(String value) {
            addCriterion("is_not_null <>", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullGreaterThan(String value) {
            addCriterion("is_not_null >", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullGreaterThanOrEqualTo(String value) {
            addCriterion("is_not_null >=", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLessThan(String value) {
            addCriterion("is_not_null <", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLessThanOrEqualTo(String value) {
            addCriterion("is_not_null <=", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLike(String value) {
            addCriterion("is_not_null like", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotLike(String value) {
            addCriterion("is_not_null not like", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIn(List<String> values) {
            addCriterion("is_not_null in", values, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotIn(List<String> values) {
            addCriterion("is_not_null not in", values, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullBetween(String value1, String value2) {
            addCriterion("is_not_null between", value1, value2, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotBetween(String value1, String value2) {
            addCriterion("is_not_null not between", value1, value2, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltIsNull() {
            addCriterion("is_sys_built is null");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltIsNotNull() {
            addCriterion("is_sys_built is not null");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltEqualTo(String value) {
            addCriterion("is_sys_built =", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltNotEqualTo(String value) {
            addCriterion("is_sys_built <>", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltGreaterThan(String value) {
            addCriterion("is_sys_built >", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltGreaterThanOrEqualTo(String value) {
            addCriterion("is_sys_built >=", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltLessThan(String value) {
            addCriterion("is_sys_built <", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltLessThanOrEqualTo(String value) {
            addCriterion("is_sys_built <=", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltLike(String value) {
            addCriterion("is_sys_built like", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltNotLike(String value) {
            addCriterion("is_sys_built not like", value, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltIn(List<String> values) {
            addCriterion("is_sys_built in", values, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltNotIn(List<String> values) {
            addCriterion("is_sys_built not in", values, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltBetween(String value1, String value2) {
            addCriterion("is_sys_built between", value1, value2, "isSysBuilt");
            return (Criteria) this;
        }

        public Criteria andIsSysBuiltNotBetween(String value1, String value2) {
            addCriterion("is_sys_built not between", value1, value2, "isSysBuilt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}