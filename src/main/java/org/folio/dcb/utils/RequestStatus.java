package org.folio.dcb.utils;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

public enum RequestStatus {
  NONE(""),
  OPEN_NOT_YET_FILLED("Open - Not yet filled"),
  OPEN_AWAITING_PICKUP("Open - Awaiting pickup"),
  OPEN_IN_TRANSIT("Open - In transit"),
  OPEN_AWAITING_DELIVERY("Open - Awaiting delivery"),
  CLOSED_FILLED("Closed - Filled"),
  CLOSED_CANCELLED("Closed - Cancelled"),
  CLOSED_UNFILLED("Closed - Unfilled"),
  CLOSED_PICKUP_EXPIRED("Closed - Pickup expired");

  private final String value;

  RequestStatus(String value) {
    this.value = value;
  }

  public static RequestStatus from(String value) {
    return Arrays.stream(values())
      .filter(status -> status.valueMatches(value))
      .findFirst()
      .orElse(NONE);
  }

  private boolean valueMatches(String value) {
    return equalsIgnoreCase(getValue(), value);
  }

  public String getValue() {
    return value;
  }
}
