package com.sunny.task.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.task.common.utils.NullUtils
 * @date 2017-10-16 11:23
 * @description:
 */
public final class NullUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    static final String NULL_STRING = "null";
    static final int NULL_STRING_LENGTH = NULL_STRING.length();
    static final NullUtils NULL_OBJECT = new NullUtils();

    // Allow instantiation for serialization
    NullUtils() {
        super();
    }

    /**
     * There is only intended to be a single instance of the NULL object, so the clone method
     * returns itself.
     *
     * @return NULL.
     */
    @Override
    protected final Object clone() {
        return this;
    }

    /**
     * A Null object is equal to the null value and to itself.
     *
     * @param object An object to test for nullness.
     * @return true if the object parameter is the JSONObject.NULL object or null.
     */
    @Override
    public boolean equals(Object object) {
        return (object == null || object == this);
    }

    /**
     * Get the "null" string value.
     *
     * @return The string "null".
     */
    @Override
    public String toString() {
        return NULL_STRING;
    }

    /**
     * @param s
     * @return 如果 s 为空值(null)、空串("")或"null"，则返回 true，否则返回 false
     */
    public static boolean isNull(String s) {
        if (null != s) {
            final int len = s.length();
            if (len > 0) {
                if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * @param o
     * @return 如果 o 为空值(null)、空串("")或"null"，则返回 true，否则返回 false
     */
    public static boolean isNull(Object o) {
        if (null != o) {
            if (o instanceof String) {
                String s = (String) o;
                final int len = s.length();
                if (len > 0) {
                    if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                        return true;
                    }
                    return false;
                }
                return true;
            } else if (o == NULL_OBJECT) {
                return true;
            } else if (o instanceof Collection) {
                return ((Collection<?>) o).isEmpty();
            } else if (o instanceof Map) {
                return ((Map<?, ?>) o).isEmpty();
            } else if (o.getClass().isArray()) {
                return (Array.getLength(o) <= 0);
            }
            return false;
        }
        return true;
    }

    /**
     * @param s
     * @return 如果 s 为空值(null)、空串("")或"null"，则返回 false，否则返回 true
     */
    public static boolean isNotNull(String s) {
        if (null != s) {
            final int len = s.length();
            if (len > 0) {
                if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * @param o
     * @return 如果 o 为空值(null)、空串("")或"null"，则返回 false，否则返回 true
     */
    public static boolean isNotNull(Object o) {
        if (null != o) {
            if (o instanceof String) {
                String s = (String) o;
                final int len = s.length();
                if (len > 0) {
                    if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                        return false;
                    }
                    return true;
                }
                return false;
            } else if (o == NULL_OBJECT) {
                return false;
            } else if (o instanceof Collection) {
                return !((Collection<?>) o).isEmpty();
            } else if (o instanceof Map) {
                return !((Map<?, ?>) o).isEmpty();
            } else if (o.getClass().isArray()) {
                return (Array.getLength(o) > 0);
            }
            return true;
        }
        return false;
    }

    /**
     * @param s
     * @param nullValue
     * @param emptyStrValue
     * @param nullStrValue
     * @param elseValue
     * @return 如果 s 为空值(null)、空串("")或"null"，则分别返回 nullValue, emptyStrValue, nullStrValue, 否则返回
     * elseValue
     */
    public static String ifNull(String s, String nullValue, String emptyStrValue, String nullStrValue, String elseValue) {
        if (null != s) {
            final int len = s.length();
            if (len > 0) {
                if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                    return nullStrValue;
                }
                return elseValue;
            }
            return emptyStrValue;
        }
        return nullValue;
    }

    /**
     * @param s
     * @param thenValue
     * @return 如果 s 为空值(null)、空串("")或"null"，则返回 thenValue，否则返回 s
     */
    public static String ifNull(String s, String thenValue) {
        if (isNull(s)) {
            return thenValue;
        }
        return s;
    }

    /**
     * @param s
     * @return 如果 s 为空值(null)、空串("")或"null"，则返回 null，否则返回 s
     */
    public static String ifNull(String s) {
        if (isNull(s)) {
            return null;
        }
        return s;
    }

    /**
     * @param o
     * @param nullValue
     * @param emptyStrValue
     * @param nullStrValue
     * @param elseValue
     * @return 如果 o 为空值(null)、空串("")或"null"，则分别返回 nullValue, emptyStrValue, nullStrValue, 否则返回
     * elseValue
     */
    public static String ifNull(Object o, String nullValue, String emptyStrValue, String nullStrValue, String elseValue) {
        if (null != o) {
            if (o instanceof String) {
                String s = (String) o;
                final int len = s.length();
                if (len > 0) {
                    if (len == NULL_STRING_LENGTH && NULL_STRING.equalsIgnoreCase(s)) {
                        return nullStrValue;
                    }
                    return elseValue;
                }
                return emptyStrValue;
            } else if (o == NULL_OBJECT) {
                return nullStrValue;
            }
            return elseValue;
        }
        return nullValue;
    }

    /**
     * @param o
     * @param thenValue
     * @return 如果 o 为空值(null)、空串("")或"null"，则返回 thenValue，否则返回 (String)o
     */
    public static String ifNull(Object o, String thenValue) {
        if (isNull(o)) {
            return thenValue;
        } else if (o instanceof String) {
            return (String) o;
        } else {
            return o.toString();
        }
    }

    /**
     * @param o
     * @return 如果 o 为空值(null)、空串("")或"null"，则返回 null，否则返回 (String)o
     */
    public static String ifNull(Object o) {
        if (isNull(o)) {
            return null;
        } else if (o instanceof String) {
            return (String) o;
        } else {
            return o.toString();
        }
    }

    /**
     * @param s1
     * @param s2
     * @return 如果 isNull(s1) && isNull(s2) 或者 s1 等于(equals) s2，则返回 null，否则返回 s1
     */
    public static String nullIf(String s1, String s2) {
        if (isNull(s1)) {
            if (isNull(s2)) {
                return null;
            }
        } else if (!isNull(s2) && (s1 == s2 || s1.equals(s2))) {
            return null;
        }
        return s1;
    }

    /**
     * @param o1
     * @param o2
     * @return 如果 isNull(o1) && isNull(o2) 或者 o1 等于(equals) o2，则返回 null，否则返回 o1
     */
    public static String nullIf(Object o1, Object o2) {
        if (isNull(o1)) {
            if (isNull(o2)) {
                return null;
            }
        } else if (!isNull(o2) && (o1 == o2 || o1.equals(o2))) {
            return null;
        }
        if (o1 instanceof String) {
            return (String) o1;
        } else {
            return o1.toString();
        }
    }

    /**
     * @param s1
     * @param s2
     * @return 如果 isNull(s1) && isNull(s2) 或者 s1 等于(equals) s2，则返回 true，否则返回 flase
     */
    public static boolean equals(String s1, String s2) {
        if (isNull(s1)) {
            if (isNull(s2)) {
                return true;
            }
        } else if (!isNull(s2) && (s1 == s2 || s1.equals(s2))) {
            return true;
        }
        return false;
    }

    /**
     * @param o1
     * @param o2
     * @return 如果 isNull(o1) && isNull(o2) 或者 o1 等于(equals) o2，则返回 true，否则返回 flase
     */
    public static boolean equals(Object o1, Object o2) {
        if (isNull(o1)) {
            if (isNull(o2)) {
                return true;
            }
        } else if (!isNull(o2) && (o1 == o2 || o1.equals(o2))) {
            return true;
        }
        return false;
    }
}
