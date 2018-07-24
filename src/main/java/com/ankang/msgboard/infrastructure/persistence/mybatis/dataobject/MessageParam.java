package com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MessageParam {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageParam() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVisitorIsNull() {
            addCriterion("visitor is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIsNotNull() {
            addCriterion("visitor is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorEqualTo(Integer value) {
            addCriterion("visitor =", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotEqualTo(Integer value) {
            addCriterion("visitor <>", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorGreaterThan(Integer value) {
            addCriterion("visitor >", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitor >=", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorLessThan(Integer value) {
            addCriterion("visitor <", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorLessThanOrEqualTo(Integer value) {
            addCriterion("visitor <=", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorIn(List<Integer> values) {
            addCriterion("visitor in", values, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotIn(List<Integer> values) {
            addCriterion("visitor not in", values, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorBetween(Integer value1, Integer value2) {
            addCriterion("visitor between", value1, value2, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotBetween(Integer value1, Integer value2) {
            addCriterion("visitor not between", value1, value2, "visitor");
            return (Criteria) this;
        }

        public Criteria andArticleIsNull() {
            addCriterion("article is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsNotNull() {
            addCriterion("article is not null");
            return (Criteria) this;
        }

        public Criteria andArticleEqualTo(Integer value) {
            addCriterion("article =", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotEqualTo(Integer value) {
            addCriterion("article <>", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThan(Integer value) {
            addCriterion("article >", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThanOrEqualTo(Integer value) {
            addCriterion("article >=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThan(Integer value) {
            addCriterion("article <", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThanOrEqualTo(Integer value) {
            addCriterion("article <=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleIn(List<Integer> values) {
            addCriterion("article in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotIn(List<Integer> values) {
            addCriterion("article not in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleBetween(Integer value1, Integer value2) {
            addCriterion("article between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotBetween(Integer value1, Integer value2) {
            addCriterion("article not between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Integer value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Integer value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Integer value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Integer value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Integer value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Integer> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Integer> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Integer value1, Integer value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Integer value1, Integer value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andMbDateIsNull() {
            addCriterion("mb_date is null");
            return (Criteria) this;
        }

        public Criteria andMbDateIsNotNull() {
            addCriterion("mb_date is not null");
            return (Criteria) this;
        }

        public Criteria andMbDateEqualTo(Instant value) {
            addCriterion("mb_date =", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateNotEqualTo(Instant value) {
            addCriterion("mb_date <>", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateGreaterThan(Instant value) {
            addCriterion("mb_date >", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateGreaterThanOrEqualTo(Instant value) {
            addCriterion("mb_date >=", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateLessThan(Instant value) {
            addCriterion("mb_date <", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateLessThanOrEqualTo(Instant value) {
            addCriterion("mb_date <=", value, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateIn(List<Instant> values) {
            addCriterion("mb_date in", values, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateNotIn(List<Instant> values) {
            addCriterion("mb_date not in", values, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateBetween(Instant value1, Instant value2) {
            addCriterion("mb_date between", value1, value2, "mbDate");
            return (Criteria) this;
        }

        public Criteria andMbDateNotBetween(Instant value1, Instant value2) {
            addCriterion("mb_date not between", value1, value2, "mbDate");
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