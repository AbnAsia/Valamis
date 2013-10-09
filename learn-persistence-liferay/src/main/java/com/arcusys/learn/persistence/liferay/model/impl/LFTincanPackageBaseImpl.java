package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LFTincanPackage service. Represents a row in the &quot;Learn_LFTincanPackage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFTincanPackageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackageImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanPackage
 * @generated
 */
public abstract class LFTincanPackageBaseImpl extends LFTincanPackageModelImpl
    implements LFTincanPackage {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f tincan package model instance should use the {@link LFTincanPackage} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanPackageLocalServiceUtil.addLFTincanPackage(this);
        } else {
            LFTincanPackageLocalServiceUtil.updateLFTincanPackage(this);
        }
    }
}