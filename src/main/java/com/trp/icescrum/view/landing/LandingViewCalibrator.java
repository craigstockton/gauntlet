package com.trp.icescrum.view.landing;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.trp.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuCalibrator;

public class LandingViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Landing' view";
    private final LandingViewExpected expected;
    private final LandingView actual;

    private LandingViewCalibrator(LandingViewExpected expected, LandingView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(NavBarPrimaryMenuCalibrator.getInstance(expected.inNavBarPrimaryMenu(), actual.inNavBarPrimaryMenu()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static LandingViewCalibrator getInstance(LandingViewExpected expected, LandingView actual) {
        return new LandingViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Try for free' button exists", expected.isTryForFreeDisplayed(), actual.isTryForFreeDisplayed());
        verify("'HubSpot Messages' icon displayed", expected.isHubSpotMessagesButtonDisplayed(), actual.isHubSpotMessagesButtonDisplayed());
    }
}
