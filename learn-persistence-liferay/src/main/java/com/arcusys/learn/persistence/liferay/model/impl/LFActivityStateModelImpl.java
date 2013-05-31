package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
* The base model implementation for the LFActivityState service. Represents a row in the &quot;Learn_LFActivityState&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFActivityStateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFActivityStateImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFActivityStateImpl
* @see com.arcusys.learn.persistence.liferay.model.LFActivityState
* @see com.arcusys.learn.persistence.liferay.model.LFActivityStateModel
* @generated
*/
public class LFActivityStateModelImpl extends BaseModelImpl<LFActivityState>
    implements LFActivityStateModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f activity state model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFActivityState} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFActivityState";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "packageID", Types.INTEGER },
            { "activityID", Types.CLOB },
            { "active_", Types.BOOLEAN },
            { "suspended", Types.BOOLEAN },
            { "attemptCompleted", Types.BOOLEAN },
            { "attemptCompletionAmount", Types.NUMERIC },
            { "attemptAbsoluteDuration", Types.NUMERIC },
            { "attemptExperiencedDuration", Types.NUMERIC },
            { "activityAbsoluteDuration", Types.NUMERIC },
            { "activityExperiencedDuration", Types.NUMERIC },
            { "attemptCount", Types.INTEGER },
            { "activityStateNodeID", Types.INTEGER },
            { "activityStateTreeID", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFActivityState (id_ LONG not null primary key,packageID INTEGER,activityID TEXT null,active_ BOOLEAN,suspended BOOLEAN,attemptCompleted BOOLEAN null,attemptCompletionAmount NUMERIC(20,2),attemptAbsoluteDuration NUMERIC(20,2),attemptExperiencedDuration NUMERIC(20,2),activityAbsoluteDuration NUMERIC(20,2),activityExperiencedDuration NUMERIC(20,2),attemptCount INTEGER,activityStateNodeID INTEGER null,activityStateTreeID INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFActivityState";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityState"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityState"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFActivityState"),
            true);
    public static long ACTIVITYID_COLUMN_BITMASK = 1L;
    public static long ACTIVITYSTATENODEID_COLUMN_BITMASK = 2L;
    public static long ACTIVITYSTATETREEID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFActivityState"));
    private static ClassLoader _classLoader = LFActivityState.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFActivityState.class
        };
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _originalActivityID;
    private Boolean _active;
    private Boolean _suspended;
    private Boolean _attemptCompleted;
    private BigDecimal _attemptCompletionAmount;
    private BigDecimal _attemptAbsoluteDuration;
    private BigDecimal _attemptExperiencedDuration;
    private BigDecimal _activityAbsoluteDuration;
    private BigDecimal _activityExperiencedDuration;
    private Integer _attemptCount;
    private Integer _activityStateNodeID;
    private Integer _originalActivityStateNodeID;
    private boolean _setOriginalActivityStateNodeID;
    private Integer _activityStateTreeID;
    private Integer _originalActivityStateTreeID;
    private boolean _setOriginalActivityStateTreeID;
    private long _columnBitmask;
    private LFActivityState _escapedModelProxy;

    public LFActivityStateModelImpl() {
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return LFActivityState.class;
    }

    public String getModelClassName() {
        return LFActivityState.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("activityID", getActivityID());
        attributes.put("active", getActive());
        attributes.put("suspended", getSuspended());
        attributes.put("attemptCompleted", getAttemptCompleted());
        attributes.put("attemptCompletionAmount", getAttemptCompletionAmount());
        attributes.put("attemptAbsoluteDuration", getAttemptAbsoluteDuration());
        attributes.put("attemptExperiencedDuration",
            getAttemptExperiencedDuration());
        attributes.put("activityAbsoluteDuration", getActivityAbsoluteDuration());
        attributes.put("activityExperiencedDuration",
            getActivityExperiencedDuration());
        attributes.put("attemptCount", getAttemptCount());
        attributes.put("activityStateNodeID", getActivityStateNodeID());
        attributes.put("activityStateTreeID", getActivityStateTreeID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        Boolean active = (Boolean) attributes.get("active");

        if (active != null) {
            setActive(active);
        }

        Boolean suspended = (Boolean) attributes.get("suspended");

        if (suspended != null) {
            setSuspended(suspended);
        }

        Boolean attemptCompleted = (Boolean) attributes.get("attemptCompleted");

        if (attemptCompleted != null) {
            setAttemptCompleted(attemptCompleted);
        }

        BigDecimal attemptCompletionAmount = (BigDecimal) attributes.get(
                "attemptCompletionAmount");

        if (attemptCompletionAmount != null) {
            setAttemptCompletionAmount(attemptCompletionAmount);
        }

        BigDecimal attemptAbsoluteDuration = (BigDecimal) attributes.get(
                "attemptAbsoluteDuration");

        if (attemptAbsoluteDuration != null) {
            setAttemptAbsoluteDuration(attemptAbsoluteDuration);
        }

        BigDecimal attemptExperiencedDuration = (BigDecimal) attributes.get(
                "attemptExperiencedDuration");

        if (attemptExperiencedDuration != null) {
            setAttemptExperiencedDuration(attemptExperiencedDuration);
        }

        BigDecimal activityAbsoluteDuration = (BigDecimal) attributes.get(
                "activityAbsoluteDuration");

        if (activityAbsoluteDuration != null) {
            setActivityAbsoluteDuration(activityAbsoluteDuration);
        }

        BigDecimal activityExperiencedDuration = (BigDecimal) attributes.get(
                "activityExperiencedDuration");

        if (activityExperiencedDuration != null) {
            setActivityExperiencedDuration(activityExperiencedDuration);
        }

        Integer attemptCount = (Integer) attributes.get("attemptCount");

        if (attemptCount != null) {
            setAttemptCount(attemptCount);
        }

        Integer activityStateNodeID = (Integer) attributes.get(
                "activityStateNodeID");

        if (activityStateNodeID != null) {
            setActivityStateNodeID(activityStateNodeID);
        }

        Integer activityStateTreeID = (Integer) attributes.get(
                "activityStateTreeID");

        if (activityStateTreeID != null) {
            setActivityStateTreeID(activityStateTreeID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getActivityID() {
        if (_activityID == null) {
            return StringPool.BLANK;
        } else {
            return _activityID;
        }
    }

    public void setActivityID(String activityID) {
        _columnBitmask |= ACTIVITYID_COLUMN_BITMASK;

        if (_originalActivityID == null) {
            _originalActivityID = _activityID;
        }

        _activityID = activityID;
    }

    public String getOriginalActivityID() {
        return GetterUtil.getString(_originalActivityID);
    }

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }

    public Boolean getSuspended() {
        return _suspended;
    }

    public void setSuspended(Boolean suspended) {
        _suspended = suspended;
    }

    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;
    }

    public BigDecimal getAttemptCompletionAmount() {
        return _attemptCompletionAmount;
    }

    public void setAttemptCompletionAmount(BigDecimal attemptCompletionAmount) {
        _attemptCompletionAmount = attemptCompletionAmount;
    }

    public BigDecimal getAttemptAbsoluteDuration() {
        return _attemptAbsoluteDuration;
    }

    public void setAttemptAbsoluteDuration(BigDecimal attemptAbsoluteDuration) {
        _attemptAbsoluteDuration = attemptAbsoluteDuration;
    }

    public BigDecimal getAttemptExperiencedDuration() {
        return _attemptExperiencedDuration;
    }

    public void setAttemptExperiencedDuration(
        BigDecimal attemptExperiencedDuration) {
        _attemptExperiencedDuration = attemptExperiencedDuration;
    }

    public BigDecimal getActivityAbsoluteDuration() {
        return _activityAbsoluteDuration;
    }

    public void setActivityAbsoluteDuration(BigDecimal activityAbsoluteDuration) {
        _activityAbsoluteDuration = activityAbsoluteDuration;
    }

    public BigDecimal getActivityExperiencedDuration() {
        return _activityExperiencedDuration;
    }

    public void setActivityExperiencedDuration(
        BigDecimal activityExperiencedDuration) {
        _activityExperiencedDuration = activityExperiencedDuration;
    }

    public Integer getAttemptCount() {
        return _attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        _attemptCount = attemptCount;
    }

    public Integer getActivityStateNodeID() {
        return _activityStateNodeID;
    }

    public void setActivityStateNodeID(Integer activityStateNodeID) {
        _columnBitmask |= ACTIVITYSTATENODEID_COLUMN_BITMASK;

        if (!_setOriginalActivityStateNodeID) {
            _setOriginalActivityStateNodeID = true;

            _originalActivityStateNodeID = _activityStateNodeID;
        }

        _activityStateNodeID = activityStateNodeID;
    }

    public Integer getOriginalActivityStateNodeID() {
        return _originalActivityStateNodeID;
    }

    public Integer getActivityStateTreeID() {
        return _activityStateTreeID;
    }

    public void setActivityStateTreeID(Integer activityStateTreeID) {
        _columnBitmask |= ACTIVITYSTATETREEID_COLUMN_BITMASK;

        if (!_setOriginalActivityStateTreeID) {
            _setOriginalActivityStateTreeID = true;

            _originalActivityStateTreeID = _activityStateTreeID;
        }

        _activityStateTreeID = activityStateTreeID;
    }

    public Integer getOriginalActivityStateTreeID() {
        return _originalActivityStateTreeID;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFActivityState.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFActivityState toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFActivityState) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFActivityStateImpl lfActivityStateImpl = new LFActivityStateImpl();

        lfActivityStateImpl.setId(getId());
        lfActivityStateImpl.setPackageID(getPackageID());
        lfActivityStateImpl.setActivityID(getActivityID());
        lfActivityStateImpl.setActive(getActive());
        lfActivityStateImpl.setSuspended(getSuspended());
        lfActivityStateImpl.setAttemptCompleted(getAttemptCompleted());
        lfActivityStateImpl.setAttemptCompletionAmount(getAttemptCompletionAmount());
        lfActivityStateImpl.setAttemptAbsoluteDuration(getAttemptAbsoluteDuration());
        lfActivityStateImpl.setAttemptExperiencedDuration(getAttemptExperiencedDuration());
        lfActivityStateImpl.setActivityAbsoluteDuration(getActivityAbsoluteDuration());
        lfActivityStateImpl.setActivityExperiencedDuration(getActivityExperiencedDuration());
        lfActivityStateImpl.setAttemptCount(getAttemptCount());
        lfActivityStateImpl.setActivityStateNodeID(getActivityStateNodeID());
        lfActivityStateImpl.setActivityStateTreeID(getActivityStateTreeID());

        lfActivityStateImpl.resetOriginalValues();

        return lfActivityStateImpl;
    }

    public int compareTo(LFActivityState lfActivityState) {
        long primaryKey = lfActivityState.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFActivityState lfActivityState = null;

        try {
            lfActivityState = (LFActivityState) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivityState.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        LFActivityStateModelImpl lfActivityStateModelImpl = this;

        lfActivityStateModelImpl._originalActivityID = lfActivityStateModelImpl._activityID;

        lfActivityStateModelImpl._originalActivityStateNodeID = lfActivityStateModelImpl._activityStateNodeID;

        lfActivityStateModelImpl._setOriginalActivityStateNodeID = false;

        lfActivityStateModelImpl._originalActivityStateTreeID = lfActivityStateModelImpl._activityStateTreeID;

        lfActivityStateModelImpl._setOriginalActivityStateTreeID = false;

        lfActivityStateModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFActivityState> toCacheModel() {
        LFActivityStateCacheModel lfActivityStateCacheModel = new LFActivityStateCacheModel();

        lfActivityStateCacheModel.id = getId();

        lfActivityStateCacheModel.packageID = getPackageID();

        lfActivityStateCacheModel.activityID = getActivityID();

        String activityID = lfActivityStateCacheModel.activityID;

        if ((activityID != null) && (activityID.length() == 0)) {
            lfActivityStateCacheModel.activityID = null;
        }

        lfActivityStateCacheModel.active = getActive();

        lfActivityStateCacheModel.suspended = getSuspended();

        lfActivityStateCacheModel.attemptCompleted = getAttemptCompleted();

        lfActivityStateCacheModel.attemptCompletionAmount = getAttemptCompletionAmount();

        lfActivityStateCacheModel.attemptAbsoluteDuration = getAttemptAbsoluteDuration();

        lfActivityStateCacheModel.attemptExperiencedDuration = getAttemptExperiencedDuration();

        lfActivityStateCacheModel.activityAbsoluteDuration = getActivityAbsoluteDuration();

        lfActivityStateCacheModel.activityExperiencedDuration = getActivityExperiencedDuration();

        lfActivityStateCacheModel.attemptCount = getAttemptCount();

        lfActivityStateCacheModel.activityStateNodeID = getActivityStateNodeID();

        lfActivityStateCacheModel.activityStateTreeID = getActivityStateTreeID();

        return lfActivityStateCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", suspended=");
        sb.append(getSuspended());
        sb.append(", attemptCompleted=");
        sb.append(getAttemptCompleted());
        sb.append(", attemptCompletionAmount=");
        sb.append(getAttemptCompletionAmount());
        sb.append(", attemptAbsoluteDuration=");
        sb.append(getAttemptAbsoluteDuration());
        sb.append(", attemptExperiencedDuration=");
        sb.append(getAttemptExperiencedDuration());
        sb.append(", activityAbsoluteDuration=");
        sb.append(getActivityAbsoluteDuration());
        sb.append(", activityExperiencedDuration=");
        sb.append(getActivityExperiencedDuration());
        sb.append(", attemptCount=");
        sb.append(getAttemptCount());
        sb.append(", activityStateNodeID=");
        sb.append(getActivityStateNodeID());
        sb.append(", activityStateTreeID=");
        sb.append(getActivityStateTreeID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFActivityState");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityID</column-name><column-value><![CDATA[");
        sb.append(getActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suspended</column-name><column-value><![CDATA[");
        sb.append(getSuspended());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCompleted</column-name><column-value><![CDATA[");
        sb.append(getAttemptCompleted());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCompletionAmount</column-name><column-value><![CDATA[");
        sb.append(getAttemptCompletionAmount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptAbsoluteDuration</column-name><column-value><![CDATA[");
        sb.append(getAttemptAbsoluteDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptExperiencedDuration</column-name><column-value><![CDATA[");
        sb.append(getAttemptExperiencedDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityAbsoluteDuration</column-name><column-value><![CDATA[");
        sb.append(getActivityAbsoluteDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityExperiencedDuration</column-name><column-value><![CDATA[");
        sb.append(getActivityExperiencedDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptCount</column-name><column-value><![CDATA[");
        sb.append(getAttemptCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateNodeID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateNodeID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateTreeID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateTreeID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}