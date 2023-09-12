package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBatchExample() {
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

        public Criteria andPcIdIsNull() {
            addCriterion("pc_id is null");
            return (Criteria) this;
        }

        public Criteria andPcIdIsNotNull() {
            addCriterion("pc_id is not null");
            return (Criteria) this;
        }

        public Criteria andPcIdEqualTo(String value) {
            addCriterion("pc_id =", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotEqualTo(String value) {
            addCriterion("pc_id <>", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdGreaterThan(String value) {
            addCriterion("pc_id >", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdGreaterThanOrEqualTo(String value) {
            addCriterion("pc_id >=", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLessThan(String value) {
            addCriterion("pc_id <", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLessThanOrEqualTo(String value) {
            addCriterion("pc_id <=", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLike(String value) {
            addCriterion("pc_id like", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotLike(String value) {
            addCriterion("pc_id not like", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdIn(List<String> values) {
            addCriterion("pc_id in", values, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotIn(List<String> values) {
            addCriterion("pc_id not in", values, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdBetween(String value1, String value2) {
            addCriterion("pc_id between", value1, value2, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotBetween(String value1, String value2) {
            addCriterion("pc_id not between", value1, value2, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNull() {
            addCriterion("pc_name is null");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNotNull() {
            addCriterion("pc_name is not null");
            return (Criteria) this;
        }

        public Criteria andPcNameEqualTo(String value) {
            addCriterion("pc_name =", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotEqualTo(String value) {
            addCriterion("pc_name <>", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThan(String value) {
            addCriterion("pc_name >", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThanOrEqualTo(String value) {
            addCriterion("pc_name >=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThan(String value) {
            addCriterion("pc_name <", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThanOrEqualTo(String value) {
            addCriterion("pc_name <=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLike(String value) {
            addCriterion("pc_name like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotLike(String value) {
            addCriterion("pc_name not like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameIn(List<String> values) {
            addCriterion("pc_name in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotIn(List<String> values) {
            addCriterion("pc_name not in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameBetween(String value1, String value2) {
            addCriterion("pc_name between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotBetween(String value1, String value2) {
            addCriterion("pc_name not between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andDalxIsNull() {
            addCriterion("dalx is null");
            return (Criteria) this;
        }

        public Criteria andDalxIsNotNull() {
            addCriterion("dalx is not null");
            return (Criteria) this;
        }

        public Criteria andDalxEqualTo(String value) {
            addCriterion("dalx =", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotEqualTo(String value) {
            addCriterion("dalx <>", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxGreaterThan(String value) {
            addCriterion("dalx >", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxGreaterThanOrEqualTo(String value) {
            addCriterion("dalx >=", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLessThan(String value) {
            addCriterion("dalx <", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLessThanOrEqualTo(String value) {
            addCriterion("dalx <=", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLike(String value) {
            addCriterion("dalx like", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotLike(String value) {
            addCriterion("dalx not like", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxIn(List<String> values) {
            addCriterion("dalx in", values, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotIn(List<String> values) {
            addCriterion("dalx not in", values, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxBetween(String value1, String value2) {
            addCriterion("dalx between", value1, value2, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotBetween(String value1, String value2) {
            addCriterion("dalx not between", value1, value2, "dalx");
            return (Criteria) this;
        }

        public Criteria andJuanshuIsNull() {
            addCriterion("juanshu is null");
            return (Criteria) this;
        }

        public Criteria andJuanshuIsNotNull() {
            addCriterion("juanshu is not null");
            return (Criteria) this;
        }

        public Criteria andJuanshuEqualTo(String value) {
            addCriterion("juanshu =", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuNotEqualTo(String value) {
            addCriterion("juanshu <>", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuGreaterThan(String value) {
            addCriterion("juanshu >", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuGreaterThanOrEqualTo(String value) {
            addCriterion("juanshu >=", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuLessThan(String value) {
            addCriterion("juanshu <", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuLessThanOrEqualTo(String value) {
            addCriterion("juanshu <=", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuLike(String value) {
            addCriterion("juanshu like", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuNotLike(String value) {
            addCriterion("juanshu not like", value, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuIn(List<String> values) {
            addCriterion("juanshu in", values, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuNotIn(List<String> values) {
            addCriterion("juanshu not in", values, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuBetween(String value1, String value2) {
            addCriterion("juanshu between", value1, value2, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJuanshuNotBetween(String value1, String value2) {
            addCriterion("juanshu not between", value1, value2, "juanshu");
            return (Criteria) this;
        }

        public Criteria andJianshuIsNull() {
            addCriterion("jianshu is null");
            return (Criteria) this;
        }

        public Criteria andJianshuIsNotNull() {
            addCriterion("jianshu is not null");
            return (Criteria) this;
        }

        public Criteria andJianshuEqualTo(String value) {
            addCriterion("jianshu =", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuNotEqualTo(String value) {
            addCriterion("jianshu <>", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuGreaterThan(String value) {
            addCriterion("jianshu >", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuGreaterThanOrEqualTo(String value) {
            addCriterion("jianshu >=", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuLessThan(String value) {
            addCriterion("jianshu <", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuLessThanOrEqualTo(String value) {
            addCriterion("jianshu <=", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuLike(String value) {
            addCriterion("jianshu like", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuNotLike(String value) {
            addCriterion("jianshu not like", value, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuIn(List<String> values) {
            addCriterion("jianshu in", values, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuNotIn(List<String> values) {
            addCriterion("jianshu not in", values, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuBetween(String value1, String value2) {
            addCriterion("jianshu between", value1, value2, "jianshu");
            return (Criteria) this;
        }

        public Criteria andJianshuNotBetween(String value1, String value2) {
            addCriterion("jianshu not between", value1, value2, "jianshu");
            return (Criteria) this;
        }

        public Criteria andPcMsIsNull() {
            addCriterion("pc_ms is null");
            return (Criteria) this;
        }

        public Criteria andPcMsIsNotNull() {
            addCriterion("pc_ms is not null");
            return (Criteria) this;
        }

        public Criteria andPcMsEqualTo(String value) {
            addCriterion("pc_ms =", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsNotEqualTo(String value) {
            addCriterion("pc_ms <>", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsGreaterThan(String value) {
            addCriterion("pc_ms >", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsGreaterThanOrEqualTo(String value) {
            addCriterion("pc_ms >=", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsLessThan(String value) {
            addCriterion("pc_ms <", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsLessThanOrEqualTo(String value) {
            addCriterion("pc_ms <=", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsLike(String value) {
            addCriterion("pc_ms like", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsNotLike(String value) {
            addCriterion("pc_ms not like", value, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsIn(List<String> values) {
            addCriterion("pc_ms in", values, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsNotIn(List<String> values) {
            addCriterion("pc_ms not in", values, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsBetween(String value1, String value2) {
            addCriterion("pc_ms between", value1, value2, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPcMsNotBetween(String value1, String value2) {
            addCriterion("pc_ms not between", value1, value2, "pcMs");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathIsNull() {
            addCriterion("prj_filepath is null");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathIsNotNull() {
            addCriterion("prj_filepath is not null");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathEqualTo(String value) {
            addCriterion("prj_filepath =", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathNotEqualTo(String value) {
            addCriterion("prj_filepath <>", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathGreaterThan(String value) {
            addCriterion("prj_filepath >", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("prj_filepath >=", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathLessThan(String value) {
            addCriterion("prj_filepath <", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathLessThanOrEqualTo(String value) {
            addCriterion("prj_filepath <=", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathLike(String value) {
            addCriterion("prj_filepath like", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathNotLike(String value) {
            addCriterion("prj_filepath not like", value, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathIn(List<String> values) {
            addCriterion("prj_filepath in", values, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathNotIn(List<String> values) {
            addCriterion("prj_filepath not in", values, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathBetween(String value1, String value2) {
            addCriterion("prj_filepath between", value1, value2, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andPrjFilepathNotBetween(String value1, String value2) {
            addCriterion("prj_filepath not between", value1, value2, "prjFilepath");
            return (Criteria) this;
        }

        public Criteria andBakpathIsNull() {
            addCriterion("bakpath is null");
            return (Criteria) this;
        }

        public Criteria andBakpathIsNotNull() {
            addCriterion("bakpath is not null");
            return (Criteria) this;
        }

        public Criteria andBakpathEqualTo(String value) {
            addCriterion("bakpath =", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathNotEqualTo(String value) {
            addCriterion("bakpath <>", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathGreaterThan(String value) {
            addCriterion("bakpath >", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathGreaterThanOrEqualTo(String value) {
            addCriterion("bakpath >=", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathLessThan(String value) {
            addCriterion("bakpath <", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathLessThanOrEqualTo(String value) {
            addCriterion("bakpath <=", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathLike(String value) {
            addCriterion("bakpath like", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathNotLike(String value) {
            addCriterion("bakpath not like", value, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathIn(List<String> values) {
            addCriterion("bakpath in", values, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathNotIn(List<String> values) {
            addCriterion("bakpath not in", values, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathBetween(String value1, String value2) {
            addCriterion("bakpath between", value1, value2, "bakpath");
            return (Criteria) this;
        }

        public Criteria andBakpathNotBetween(String value1, String value2) {
            addCriterion("bakpath not between", value1, value2, "bakpath");
            return (Criteria) this;
        }

        public Criteria andReceiveByIsNull() {
            addCriterion("receive_by is null");
            return (Criteria) this;
        }

        public Criteria andReceiveByIsNotNull() {
            addCriterion("receive_by is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveByEqualTo(String value) {
            addCriterion("receive_by =", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByNotEqualTo(String value) {
            addCriterion("receive_by <>", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByGreaterThan(String value) {
            addCriterion("receive_by >", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByGreaterThanOrEqualTo(String value) {
            addCriterion("receive_by >=", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByLessThan(String value) {
            addCriterion("receive_by <", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByLessThanOrEqualTo(String value) {
            addCriterion("receive_by <=", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByLike(String value) {
            addCriterion("receive_by like", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByNotLike(String value) {
            addCriterion("receive_by not like", value, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByIn(List<String> values) {
            addCriterion("receive_by in", values, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByNotIn(List<String> values) {
            addCriterion("receive_by not in", values, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByBetween(String value1, String value2) {
            addCriterion("receive_by between", value1, value2, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveByNotBetween(String value1, String value2) {
            addCriterion("receive_by not between", value1, value2, "receiveBy");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andLqslIsNull() {
            addCriterion("lqsl is null");
            return (Criteria) this;
        }

        public Criteria andLqslIsNotNull() {
            addCriterion("lqsl is not null");
            return (Criteria) this;
        }

        public Criteria andLqslEqualTo(String value) {
            addCriterion("lqsl =", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslNotEqualTo(String value) {
            addCriterion("lqsl <>", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslGreaterThan(String value) {
            addCriterion("lqsl >", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslGreaterThanOrEqualTo(String value) {
            addCriterion("lqsl >=", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslLessThan(String value) {
            addCriterion("lqsl <", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslLessThanOrEqualTo(String value) {
            addCriterion("lqsl <=", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslLike(String value) {
            addCriterion("lqsl like", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslNotLike(String value) {
            addCriterion("lqsl not like", value, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslIn(List<String> values) {
            addCriterion("lqsl in", values, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslNotIn(List<String> values) {
            addCriterion("lqsl not in", values, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslBetween(String value1, String value2) {
            addCriterion("lqsl between", value1, value2, "lqsl");
            return (Criteria) this;
        }

        public Criteria andLqslNotBetween(String value1, String value2) {
            addCriterion("lqsl not between", value1, value2, "lqsl");
            return (Criteria) this;
        }

        public Criteria andReturnByIsNull() {
            addCriterion("return_by is null");
            return (Criteria) this;
        }

        public Criteria andReturnByIsNotNull() {
            addCriterion("return_by is not null");
            return (Criteria) this;
        }

        public Criteria andReturnByEqualTo(String value) {
            addCriterion("return_by =", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByNotEqualTo(String value) {
            addCriterion("return_by <>", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByGreaterThan(String value) {
            addCriterion("return_by >", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByGreaterThanOrEqualTo(String value) {
            addCriterion("return_by >=", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByLessThan(String value) {
            addCriterion("return_by <", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByLessThanOrEqualTo(String value) {
            addCriterion("return_by <=", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByLike(String value) {
            addCriterion("return_by like", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByNotLike(String value) {
            addCriterion("return_by not like", value, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByIn(List<String> values) {
            addCriterion("return_by in", values, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByNotIn(List<String> values) {
            addCriterion("return_by not in", values, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByBetween(String value1, String value2) {
            addCriterion("return_by between", value1, value2, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnByNotBetween(String value1, String value2) {
            addCriterion("return_by not between", value1, value2, "returnBy");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNull() {
            addCriterion("return_time is null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNotNull() {
            addCriterion("return_time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeEqualTo(Date value) {
            addCriterion("return_time =", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotEqualTo(Date value) {
            addCriterion("return_time <>", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThan(Date value) {
            addCriterion("return_time >", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("return_time >=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThan(Date value) {
            addCriterion("return_time <", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("return_time <=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIn(List<Date> values) {
            addCriterion("return_time in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotIn(List<Date> values) {
            addCriterion("return_time not in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeBetween(Date value1, Date value2) {
            addCriterion("return_time between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("return_time not between", value1, value2, "returnTime");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("begindate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("begindate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterion("begindate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterion("begindate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterion("begindate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("begindate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterion("begindate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterion("begindate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterion("begindate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterion("begindate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterion("begindate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterion("begindate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andIsfinishedIsNull() {
            addCriterion("isfinished is null");
            return (Criteria) this;
        }

        public Criteria andIsfinishedIsNotNull() {
            addCriterion("isfinished is not null");
            return (Criteria) this;
        }

        public Criteria andIsfinishedEqualTo(String value) {
            addCriterion("isfinished =", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedNotEqualTo(String value) {
            addCriterion("isfinished <>", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedGreaterThan(String value) {
            addCriterion("isfinished >", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedGreaterThanOrEqualTo(String value) {
            addCriterion("isfinished >=", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedLessThan(String value) {
            addCriterion("isfinished <", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedLessThanOrEqualTo(String value) {
            addCriterion("isfinished <=", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedLike(String value) {
            addCriterion("isfinished like", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedNotLike(String value) {
            addCriterion("isfinished not like", value, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedIn(List<String> values) {
            addCriterion("isfinished in", values, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedNotIn(List<String> values) {
            addCriterion("isfinished not in", values, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedBetween(String value1, String value2) {
            addCriterion("isfinished between", value1, value2, "isfinished");
            return (Criteria) this;
        }

        public Criteria andIsfinishedNotBetween(String value1, String value2) {
            addCriterion("isfinished not between", value1, value2, "isfinished");
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