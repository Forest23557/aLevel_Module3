package com.shulha.enums;

public enum Groups {
    NONE,
    APS_1_1,
    APS_1_2,
    APS_1_3,
    APS_1_4,
    APS_2_1,
    APS_2_2,
    APS_2_3,
    APS_2_4,
    APS_3_1,
    APS_3_2,
    APS_3_3,
    APS_3_4,
    APS_4_1,
    APS_4_2,
    APS_4_3,
    APS_4_4,
    AC_1_1,
    AC_1_2,
    AC_1_3,
    AC_1_4,
    AC_2_1,
    AC_2_2,
    AC_2_3,
    AC_2_4,
    AC_3_1,
    AC_3_2,
    AC_3_3,
    AC_3_4,
    AC_4_1,
    AC_4_2,
    AC_4_3,
    AC_4_4,
    BM_1_1,
    BM_1_2,
    BM_1_3,
    BM_1_4,
    BM_2_1,
    BM_2_2,
    BM_2_3,
    BM_2_4,
    BM_3_1,
    BM_3_2,
    BM_3_3,
    BM_3_4,
    BM_4_1,
    BM_4_2,
    BM_4_3,
    BM_4_4,
    CS_IT_1_1,
    CS_IT_1_2,
    CS_IT_1_3,
    CS_IT_1_4,
    CS_IT_2_1,
    CS_IT_2_2,
    CS_IT_2_3,
    CS_IT_2_4,
    CS_IT_3_1,
    CS_IT_3_2,
    CS_IT_3_3,
    CS_IT_3_4,
    CS_IT_4_1,
    CS_IT_4_2,
    CS_IT_4_3,
    CS_IT_4_4,
    CA_D_1_1,
    CA_D_1_2,
    CA_D_1_3,
    CA_D_1_4,
    CA_D_2_1,
    CA_D_2_2,
    CA_D_2_3,
    CA_D_2_4,
    CA_D_3_1,
    CA_D_3_2,
    CA_D_3_3,
    CA_D_3_4,
    CA_D_4_1,
    CA_D_4_2,
    CA_D_4_3,
    CA_D_4_4;

    public static int getIndexByName(final String name) {
        int index = -1;

        for(Groups group : values()) {
            final String groupValue = group.toString()
                    .toLowerCase();
            final String lowerName = name.toLowerCase();

            if (groupValue.contains(lowerName)) {
                index = group.ordinal();
                break;
            }
        }

        return index;
    }
}
