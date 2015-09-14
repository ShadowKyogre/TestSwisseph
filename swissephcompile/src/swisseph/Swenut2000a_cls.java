
/*
   This is a port of the Swiss Ephemeris Free Edition, Version 2.00.00
   of Astrodienst AG, Switzerland from the original C Code to Java. For
   copyright see the original copyright notices below and additional
   copyright notes in the file named LICENSE, or - if this file is not
   available - the copyright notes at http://www.astro.ch/swisseph/ and
   following.

   For any questions or comments regarding this port to Java, you should
   ONLY contact me and not Astrodienst, as the Astrodienst AG is not involved
   in this port in any way.

   Thomas Mack, mack@ifis.cs.tu-bs.de, 28rd of April 2006

*/
/* Copyright (C) 1997, 1998 Astrodienst AG, Switzerland.  All rights reserved.
  
  This file is part of Swiss Ephemeris Free Edition.
  
  Swiss Ephemeris is distributed with NO WARRANTY OF ANY KIND.  No author
  or distributor accepts any responsibility for the consequences of using it,
  or for whether it serves any particular purpose or works at all, unless he
  or she says so in writing.  Refer to the Swiss Ephemeris Public License
  ("SEPL" or the "License") for full details.
  
  Every copy of Swiss Ephemeris must include a copy of the License,
  normally in a plain ASCII text file named LICENSE.  The License grants you
  the right to copy, modify and redistribute Swiss Ephemeris, but only
  under certain conditions described in the License.  Among other things, the
  License requires that the copyright notices and this notice be preserved on
  all copies.

  For uses of the Swiss Ephemeris which do not fall under the definitions
  laid down in the Public License, the Swiss Ephemeris Professional Edition
  must be purchased by the developer before he/she distributes any of his
  software or makes available any product or service built upon the use of
  the Swiss Ephemeris.

  Authors of the Swiss Ephemeris: Dieter Koch and Alois Treindl

  The authors of Swiss Ephemeris have no control or influence over any of
  the derived works, i.e. over software or services created by other
  programmers which use Swiss Ephemeris functions.

  The names of the authors or of the copyright holder (Astrodienst) must not
  be used for promoting any software, product or service which uses or contains
  the Swiss Ephemeris. This copyright notice is the ONLY place where the
  names of the authors can legally appear, except in cases where they have
  given special permission in writing.

  The trademarks 'Swiss Ephemeris' and 'Swiss Ephemeris inside' may be used
  for promoting such software, products or services.
*/
package swisseph;

public class Swenut2000a_cls
		implements java.io.Serializable
		{
  /* 0.1 microarcsecond to degrees */
  static final double O1MAS2DEG = 1 / 3600.0 / 10000000.0;
  /* Number of terms in the luni-solar nutation model */
  static final int NLS = 678;
  static final int NLS_2000B = 77;
  /* Number of terms in the planetary nutation model */
  static final int NPL = 687;

  /* Luni-Solar nutation coefficients, unit 1e-7 arcsec
   * longitude (sin, t*sin, cos), obliquity (cos, t*cos, sin) */
  static final int cls[] = {
  -172064161, -174666, 33386, 92052331, 9086, 15377,
  -13170906, -1675, -13696, 5730336, -3015, -4587,
  -2276413, -234, 2796, 978459, -485, 1374,
  2074554, 207, -698, -897492, 470, -291,
  1475877, -3633, 11817, 73871, -184, -1924,
  -516821, 1226, -524, 224386, -677, -174,
  711159, 73, -872, -6750, 0, 358,
  -387298, -367, 380, 200728, 18, 318,
  -301461, -36, 816, 129025, -63, 367,
  215829, -494, 111, -95929, 299, 132,
  128227, 137, 181, -68982, -9, 39,
  123457, 11, 19, -53311, 32, -4,
  156994, 10, -168, -1235, 0, 82,
  63110, 63, 27, -33228, 0, -9,
  -57976, -63, -189, 31429, 0, -75,
  -59641, -11, 149, 25543, -11, 66,
  -51613, -42, 129, 26366, 0, 78,
  45893, 50, 31, -24236, -10, 20,
  63384, 11, -150, -1220, 0, 29,
  -38571, -1, 158, 16452, -11, 68,
  32481, 0, 0, -13870, 0, 0,
  -47722, 0, -18, 477, 0, -25,
  -31046, -1, 131, 13238, -11, 59,
  28593, 0, -1, -12338, 10, -3,
  20441, 21, 10, -10758, 0, -3,
  29243, 0, -74, -609, 0, 13,
  25887, 0, -66, -550, 0, 11,
  -14053, -25, 79, 8551, -2, -45,
  15164, 10, 11, -8001, 0, -1,
  -15794, 72, -16, 6850, -42, -5,
  21783, 0, 13, -167, 0, 13,
  -12873, -10, -37, 6953, 0, -14,
  -12654, 11, 63, 6415, 0, 26,
  -10204, 0, 25, 5222, 0, 15,
  16707, -85, -10, 168, -1, 10,
  -7691, 0, 44, 3268, 0, 19,
  -11024, 0, -14, 104, 0, 2,
  7566, -21, -11, -3250, 0, -5,
  -6637, -11, 25, 3353, 0, 14,
  -7141, 21, 8, 3070, 0, 4,
  -6302, -11, 2, 3272, 0, 4,
  5800, 10, 2, -3045, 0, -1,
  6443, 0, -7, -2768, 0, -4,
  -5774, -11, -15, 3041, 0, -5,
  -5350, 0, 21, 2695, 0, 12,
  -4752, -11, -3, 2719, 0, -3,
  -4940, -11, -21, 2720, 0, -9,
  7350, 0, -8, -51, 0, 4,
  4065, 0, 6, -2206, 0, 1,
  6579, 0, -24, -199, 0, 2,
  3579, 0, 5, -1900, 0, 1,
  4725, 0, -6, -41, 0, 3,
  -3075, 0, -2, 1313, 0, -1,
  -2904, 0, 15, 1233, 0, 7,
  4348, 0, -10, -81, 0, 2,
  -2878, 0, 8, 1232, 0, 4,
  -4230, 0, 5, -20, 0, -2,
  -2819, 0, 7, 1207, 0, 3,
  -4056, 0, 5, 40, 0, -2,
  -2647, 0, 11, 1129, 0, 5,
  -2294, 0, -10, 1266, 0, -4,
  2481, 0, -7, -1062, 0, -3,
  2179, 0, -2, -1129, 0, -2,
  3276, 0, 1, -9, 0, 0,
  -3389, 0, 5, 35, 0, -2,
  3339, 0, -13, -107, 0, 1,
  -1987, 0, -6, 1073, 0, -2,
  -1981, 0, 0, 854, 0, 0,
  4026, 0, -353, -553, 0, -139,
  1660, 0, -5, -710, 0, -2,
  -1521, 0, 9, 647, 0, 4,
  1314, 0, 0, -700, 0, 0,
  -1283, 0, 0, 672, 0, 0,
  -1331, 0, 8, 663, 0, 4,
  1383, 0, -2, -594, 0, -2,
  1405, 0, 4, -610, 0, 2,
  1290, 0, 0, -556, 0, 0,
  -1214, 0, 5, 518, 0, 2,
  1146, 0, -3, -490, 0, -1,
  1019, 0, -1, -527, 0, -1,
  -1100, 0, 9, 465, 0, 4,
  -970, 0, 2, 496, 0, 1,
  1575, 0, -6, -50, 0, 0,
  934, 0, -3, -399, 0, -1,
  922, 0, -1, -395, 0, -1,
  815, 0, -1, -422, 0, -1,
  834, 0, 2, -440, 0, 1,
  1248, 0, 0, -170, 0, 1,
  1338, 0, -5, -39, 0, 0,
  716, 0, -2, -389, 0, -1,
  1282, 0, -3, -23, 0, 1,
  742, 0, 1, -391, 0, 0,
  1020, 0, -25, -495, 0, -10,
  715, 0, -4, -326, 0, 2,
  -666, 0, -3, 369, 0, -1,
  -667, 0, 1, 346, 0, 1,
  -704, 0, 0, 304, 0, 0,
  -694, 0, 5, 294, 0, 2,
  -1014, 0, -1, 4, 0, -1,
  -585, 0, -2, 316, 0, -1,
  -949, 0, 1, 8, 0, -1,
  -595, 0, 0, 258, 0, 0,
  528, 0, 0, -279, 0, 0,
  -590, 0, 4, 252, 0, 2,
  570, 0, -2, -244, 0, -1,
  -502, 0, 3, 250, 0, 2,
  -875, 0, 1, 29, 0, 0,
  -492, 0, -3, 275, 0, -1,
  535, 0, -2, -228, 0, -1,
  -467, 0, 1, 240, 0, 1,
  591, 0, 0, -253, 0, 0,
  -453, 0, -1, 244, 0, -1,
  766, 0, 1, 9, 0, 0,
  -446, 0, 2, 225, 0, 1,
  -488, 0, 2, 207, 0, 1,
  -468, 0, 0, 201, 0, 0,
  -421, 0, 1, 216, 0, 1,
  463, 0, 0, -200, 0, 0,
  -673, 0, 2, 14, 0, 0,
  658, 0, 0, -2, 0, 0,
  -438, 0, 0, 188, 0, 0,
  -390, 0, 0, 205, 0, 0,
  639, -11, -2, -19, 0, 0,
  412, 0, -2, -176, 0, -1,
  -361, 0, 0, 189, 0, 0,
  360, 0, -1, -185, 0, -1,
  588, 0, -3, -24, 0, 0,
  -578, 0, 1, 5, 0, 0,
  -396, 0, 0, 171, 0, 0,
  565, 0, -1, -6, 0, 0,
  -335, 0, -1, 184, 0, -1,
  357, 0, 1, -154, 0, 0,
  321, 0, 1, -174, 0, 0,
  -301, 0, -1, 162, 0, 0,
  -334, 0, 0, 144, 0, 0,
  493, 0, -2, -15, 0, 0,
  494, 0, -2, -19, 0, 0,
  337, 0, -1, -143, 0, -1,
  280, 0, -1, -144, 0, 0,
  309, 0, 1, -134, 0, 0,
  -263, 0, 2, 131, 0, 1,
  253, 0, 1, -138, 0, 0,
  245, 0, 0, -128, 0, 0,
  416, 0, -2, -17, 0, 0,
  -229, 0, 0, 128, 0, 0,
  231, 0, 0, -120, 0, 0,
  -259, 0, 2, 109, 0, 1,
  375, 0, -1, -8, 0, 0,
  252, 0, 0, -108, 0, 0,
  -245, 0, 1, 104, 0, 0,
  243, 0, -1, -104, 0, 0,
  208, 0, 1, -112, 0, 0,
  199, 0, 0, -102, 0, 0,
  -208, 0, 1, 105, 0, 0,
  335, 0, -2, -14, 0, 0,
  -325, 0, 1, 7, 0, 0,
  -187, 0, 0, 96, 0, 0,
  197, 0, -1, -100, 0, 0,
  -192, 0, 2, 94, 0, 1,
  -188, 0, 0, 83, 0, 0,
  276, 0, 0, -2, 0, 0,
  -286, 0, 1, 6, 0, 0,
  186, 0, -1, -79, 0, 0,
  -219, 0, 0, 43, 0, 0,
  276, 0, 0, 2, 0, 0,
  -153, 0, -1, 84, 0, 0,
  -156, 0, 0, 81, 0, 0,
  -154, 0, 1, 78, 0, 0,
  -174, 0, 1, 75, 0, 0,
  -163, 0, 2, 69, 0, 1,
  -228, 0, 0, 1, 0, 0,
  91, 0, -4, -54, 0, -2,
  175, 0, 0, -75, 0, 0,
  -159, 0, 0, 69, 0, 0,
  141, 0, 0, -72, 0, 0,
  147, 0, 0, -75, 0, 0,
  -132, 0, 0, 69, 0, 0,
  159, 0, -28, -54, 0, 11,
  213, 0, 0, -4, 0, 0,
  123, 0, 0, -64, 0, 0,
  -118, 0, -1, 66, 0, 0,
  144, 0, -1, -61, 0, 0,
  -121, 0, 1, 60, 0, 0,
  -134, 0, 1, 56, 0, 1,
  -105, 0, 0, 57, 0, 0,
  -102, 0, 0, 56, 0, 0,
  120, 0, 0, -52, 0, 0,
  101, 0, 0, -54, 0, 0,
  -113, 0, 0, 59, 0, 0,
  -106, 0, 0, 61, 0, 0,
  -129, 0, 1, 55, 0, 0,
  -114, 0, 0, 57, 0, 0,
  113, 0, -1, -49, 0, 0,
  -102, 0, 0, 44, 0, 0,
  -94, 0, 0, 51, 0, 0,
  -100, 0, -1, 56, 0, 0,
  87, 0, 0, -47, 0, 0,
  161, 0, 0, -1, 0, 0,
  96, 0, 0, -50, 0, 0,
  151, 0, -1, -5, 0, 0,
  -104, 0, 0, 44, 0, 0,
  -110, 0, 0, 48, 0, 0,
  -100, 0, 1, 50, 0, 0,
  92, 0, -5, 12, 0, -2,
  82, 0, 0, -45, 0, 0,
  82, 0, 0, -45, 0, 0,
  -78, 0, 0, 41, 0, 0,
  -77, 0, 0, 43, 0, 0,
  2, 0, 0, 54, 0, 0,
  94, 0, 0, -40, 0, 0,
  -93, 0, 0, 40, 0, 0,
  -83, 0, 10, 40, 0, -2,
  83, 0, 0, -36, 0, 0,
  -91, 0, 0, 39, 0, 0,
  128, 0, 0, -1, 0, 0,
  -79, 0, 0, 34, 0, 0,
  -83, 0, 0, 47, 0, 0,
  84, 0, 0, -44, 0, 0,
  83, 0, 0, -43, 0, 0,
  91, 0, 0, -39, 0, 0,
  -77, 0, 0, 39, 0, 0,
  84, 0, 0, -43, 0, 0,
  -92, 0, 1, 39, 0, 0,
  -92, 0, 1, 39, 0, 0,
  -94, 0, 0, 0, 0, 0,
  68, 0, 0, -36, 0, 0,
  -61, 0, 0, 32, 0, 0,
  71, 0, 0, -31, 0, 0,
  62, 0, 0, -34, 0, 0,
  -63, 0, 0, 33, 0, 0,
  -73, 0, 0, 32, 0, 0,
  115, 0, 0, -2, 0, 0,
  -103, 0, 0, 2, 0, 0,
  63, 0, 0, -28, 0, 0,
  74, 0, 0, -32, 0, 0,
  -103, 0, -3, 3, 0, -1,
  -69, 0, 0, 30, 0, 0,
  57, 0, 0, -29, 0, 0,
  94, 0, 0, -4, 0, 0,
  64, 0, 0, -33, 0, 0,
  -63, 0, 0, 26, 0, 0,
  -38, 0, 0, 20, 0, 0,
  -43, 0, 0, 24, 0, 0,
  -45, 0, 0, 23, 0, 0,
  47, 0, 0, -24, 0, 0,
  -48, 0, 0, 25, 0, 0,
  45, 0, 0, -26, 0, 0,
  56, 0, 0, -25, 0, 0,
  88, 0, 0, 2, 0, 0,
  -75, 0, 0, 0, 0, 0,
  85, 0, 0, 0, 0, 0,
  49, 0, 0, -26, 0, 0,
  -74, 0, -3, -1, 0, -1,
  -39, 0, 0, 21, 0, 0,
  45, 0, 0, -20, 0, 0,
  51, 0, 0, -22, 0, 0,
  -40, 0, 0, 21, 0, 0,
  41, 0, 0, -21, 0, 0,
  -42, 0, 0, 24, 0, 0,
  -51, 0, 0, 22, 0, 0,
  -42, 0, 0, 22, 0, 0,
  39, 0, 0, -21, 0, 0,
  46, 0, 0, -18, 0, 0,
  -53, 0, 0, 22, 0, 0,
  82, 0, 0, -4, 0, 0,
  81, 0, -1, -4, 0, 0,
  47, 0, 0, -19, 0, 0,
  53, 0, 0, -23, 0, 0,
  -45, 0, 0, 22, 0, 0,
  -44, 0, 0, -2, 0, 0,
  -33, 0, 0, 16, 0, 0,
  -61, 0, 0, 1, 0, 0,
  28, 0, 0, -15, 0, 0,
  -38, 0, 0, 19, 0, 0,
  -33, 0, 0, 21, 0, 0,
  -60, 0, 0, 0, 0, 0,
  48, 0, 0, -10, 0, 0,
  27, 0, 0, -14, 0, 0,
  38, 0, 0, -20, 0, 0,
  31, 0, 0, -13, 0, 0,
  -29, 0, 0, 15, 0, 0,
  28, 0, 0, -15, 0, 0,
  -32, 0, 0, 15, 0, 0,
  45, 0, 0, -8, 0, 0,
  -44, 0, 0, 19, 0, 0,
  28, 0, 0, -15, 0, 0,
  -51, 0, 0, 0, 0, 0,
  -36, 0, 0, 20, 0, 0,
  44, 0, 0, -19, 0, 0,
  26, 0, 0, -14, 0, 0,
  -60, 0, 0, 2, 0, 0,
  35, 0, 0, -18, 0, 0,
  -27, 0, 0, 11, 0, 0,
  47, 0, 0, -1, 0, 0,
  36, 0, 0, -15, 0, 0,
  -36, 0, 0, 20, 0, 0,
  -35, 0, 0, 19, 0, 0,
  -37, 0, 0, 19, 0, 0,
  32, 0, 0, -16, 0, 0,
  35, 0, 0, -14, 0, 0,
  32, 0, 0, -13, 0, 0,
  65, 0, 0, -2, 0, 0,
  47, 0, 0, -1, 0, 0,
  32, 0, 0, -16, 0, 0,
  37, 0, 0, -16, 0, 0,
  -30, 0, 0, 15, 0, 0,
  -32, 0, 0, 16, 0, 0,
  -31, 0, 0, 13, 0, 0,
  37, 0, 0, -16, 0, 0,
  31, 0, 0, -13, 0, 0,
  49, 0, 0, -2, 0, 0,
  32, 0, 0, -13, 0, 0,
  23, 0, 0, -12, 0, 0,
  -43, 0, 0, 18, 0, 0,
  26, 0, 0, -11, 0, 0,
  -32, 0, 0, 14, 0, 0,
  -29, 0, 0, 14, 0, 0,
  -27, 0, 0, 12, 0, 0,
  30, 0, 0, 0, 0, 0,
  -11, 0, 0, 5, 0, 0,
  -21, 0, 0, 10, 0, 0,
  -34, 0, 0, 15, 0, 0,
  -10, 0, 0, 6, 0, 0,
  -36, 0, 0, 0, 0, 0,
  -9, 0, 0, 4, 0, 0,
  -12, 0, 0, 5, 0, 0,
  -21, 0, 0, 5, 0, 0,
  -29, 0, 0, -1, 0, 0,
  -15, 0, 0, 3, 0, 0,
  -20, 0, 0, 0, 0, 0,
  28, 0, 0, 0, 0, -2,
  17, 0, 0, 0, 0, 0,
  -22, 0, 0, 12, 0, 0,
  -14, 0, 0, 7, 0, 0,
  24, 0, 0, -11, 0, 0,
  11, 0, 0, -6, 0, 0,
  14, 0, 0, -6, 0, 0,
  24, 0, 0, 0, 0, 0,
  18, 0, 0, -8, 0, 0,
  -38, 0, 0, 0, 0, 0,
  -31, 0, 0, 0, 0, 0,
  -16, 0, 0, 8, 0, 0,
  29, 0, 0, 0, 0, 0,
  -18, 0, 0, 10, 0, 0,
  -10, 0, 0, 5, 0, 0,
  -17, 0, 0, 10, 0, 0,
  9, 0, 0, -4, 0, 0,
  16, 0, 0, -6, 0, 0,
  22, 0, 0, -12, 0, 0,
  20, 0, 0, 0, 0, 0,
  -13, 0, 0, 6, 0, 0,
  -17, 0, 0, 9, 0, 0,
  -14, 0, 0, 8, 0, 0,
  0, 0, 0, -7, 0, 0,
  14, 0, 0, 0, 0, 0,
  19, 0, 0, -10, 0, 0,
  -34, 0, 0, 0, 0, 0,
  -20, 0, 0, 8, 0, 0,
  9, 0, 0, -5, 0, 0,
  -18, 0, 0, 7, 0, 0,
  13, 0, 0, -6, 0, 0,
  17, 0, 0, 0, 0, 0,
  -12, 0, 0, 5, 0, 0,
  15, 0, 0, -8, 0, 0,
  -11, 0, 0, 3, 0, 0,
  13, 0, 0, -5, 0, 0,
  -18, 0, 0, 0, 0, 0,
  -35, 0, 0, 0, 0, 0,
  9, 0, 0, -4, 0, 0,
  -19, 0, 0, 10, 0, 0,
  -26, 0, 0, 11, 0, 0,
  8, 0, 0, -4, 0, 0,
  -10, 0, 0, 4, 0, 0,
  10, 0, 0, -6, 0, 0,
  -21, 0, 0, 9, 0, 0,
  -15, 0, 0, 0, 0, 0,
  9, 0, 0, -5, 0, 0,
  -29, 0, 0, 0, 0, 0,
  -19, 0, 0, 10, 0, 0,
  12, 0, 0, -5, 0, 0,
  22, 0, 0, -9, 0, 0,
  -10, 0, 0, 5, 0, 0,
  -20, 0, 0, 11, 0, 0,
  -20, 0, 0, 0, 0, 0,
  -17, 0, 0, 7, 0, 0,
  15, 0, 0, -3, 0, 0,
  8, 0, 0, -4, 0, 0,
  14, 0, 0, 0, 0, 0,
  -12, 0, 0, 6, 0, 0,
  25, 0, 0, 0, 0, 0,
  -13, 0, 0, 6, 0, 0,
  -14, 0, 0, 8, 0, 0,
  13, 0, 0, -5, 0, 0,
  -17, 0, 0, 9, 0, 0,
  -12, 0, 0, 6, 0, 0,
  -10, 0, 0, 5, 0, 0,
  10, 0, 0, -6, 0, 0,
  -15, 0, 0, 0, 0, 0,
  -22, 0, 0, 0, 0, 0,
  28, 0, 0, -1, 0, 0,
  15, 0, 0, -7, 0, 0,
  23, 0, 0, -10, 0, 0,
  12, 0, 0, -5, 0, 0,
  29, 0, 0, -1, 0, 0,
  -25, 0, 0, 1, 0, 0,
  22, 0, 0, 0, 0, 0,
  -18, 0, 0, 0, 0, 0,
  15, 0, 0, 3, 0, 0,
  -23, 0, 0, 0, 0, 0,
  12, 0, 0, -5, 0, 0,
  -8, 0, 0, 4, 0, 0,
  -19, 0, 0, 0, 0, 0,
  -10, 0, 0, 4, 0, 0,
  21, 0, 0, -9, 0, 0,
  23, 0, 0, -1, 0, 0,
  -16, 0, 0, 8, 0, 0,
  -19, 0, 0, 9, 0, 0,
  -22, 0, 0, 10, 0, 0,
  27, 0, 0, -1, 0, 0,
  16, 0, 0, -8, 0, 0,
  19, 0, 0, -8, 0, 0,
  9, 0, 0, -4, 0, 0,
  -9, 0, 0, 4, 0, 0,
  -9, 0, 0, 4, 0, 0,
  -8, 0, 0, 4, 0, 0,
  18, 0, 0, -9, 0, 0,
  16, 0, 0, -1, 0, 0,
  -10, 0, 0, 4, 0, 0,
  -23, 0, 0, 9, 0, 0,
  16, 0, 0, -1, 0, 0,
  -12, 0, 0, 6, 0, 0,
  -8, 0, 0, 4, 0, 0,
  30, 0, 0, -2, 0, 0,
  24, 0, 0, -10, 0, 0,
  10, 0, 0, -4, 0, 0,
  -16, 0, 0, 7, 0, 0,
  -16, 0, 0, 7, 0, 0,
  17, 0, 0, -7, 0, 0,
  -24, 0, 0, 10, 0, 0,
  -12, 0, 0, 5, 0, 0,
  -24, 0, 0, 11, 0, 0,
  -23, 0, 0, 9, 0, 0,
  -13, 0, 0, 5, 0, 0,
  -15, 0, 0, 7, 0, 0,
  0, 0, -1988, 0, 0, -1679,
  0, 0, -63, 0, 0, -27,
  -4, 0, 0, 0, 0, 0,
  0, 0, 5, 0, 0, 4,
  5, 0, 0, -3, 0, 0,
  0, 0, 364, 0, 0, 176,
  0, 0, -1044, 0, 0, -891,
  -3, 0, 0, 1, 0, 0,
  4, 0, 0, -2, 0, 0,
  0, 0, 330, 0, 0, 0,
  5, 0, 0, -2, 0, 0,
  3, 0, 0, -2, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -5, 0, 0, 2, 0, 0,
  3, 0, 0, -1, 0, 0,
  3, 0, 0, 0, 0, 0,
  3, 0, 0, 0, 0, 0,
  0, 0, 5, 0, 0, 0,
  0, 0, 0, 1, 0, 0,
  4, 0, 0, -2, 0, 0,
  6, 0, 0, 0, 0, 0,
  5, 0, 0, -2, 0, 0,
  -7, 0, 0, 0, 0, 0,
  -12, 0, 0, 0, 0, 0,
  5, 0, 0, -3, 0, 0,
  3, 0, 0, -1, 0, 0,
  -5, 0, 0, 0, 0, 0,
  3, 0, 0, 0, 0, 0,
  -7, 0, 0, 3, 0, 0,
  7, 0, 0, -4, 0, 0,
  0, 0, -12, 0, 0, -10,
  4, 0, 0, -2, 0, 0,
  3, 0, 0, -2, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -7, 0, 0, 3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -3, 0, 0, 1, 0, 0,
  0, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  7, 0, 0, -3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  -5, 0, 0, 3, 0, 0,
  5, 0, 0, 0, 0, 0,
  -5, 0, 0, 2, 0, 0,
  5, 0, 0, -2, 0, 0,
  -8, 0, 0, 3, 0, 0,
  9, 0, 0, 0, 0, 0,
  6, 0, 0, -3, 0, 0,
  -5, 0, 0, 2, 0, 0,
  3, 0, 0, 0, 0, 0,
  -7, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  5, 0, 0, 0, 0, 0,
  3, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  3, 0, 0, -1, 0, 0,
  -5, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  9, 0, 0, -3, 0, 0,
  4, 0, 0, 0, 0, 0,
  4, 0, 0, -2, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -4, 0, 0, 2, 0, 0,
  9, 0, 0, -3, 0, 0,
  -4, 0, 0, 0, 0, 0,
  -4, 0, 0, 0, 0, 0,
  3, 0, 0, -2, 0, 0,
  8, 0, 0, 0, 0, 0,
  3, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  3, 0, 0, -1, 0, 0,
  3, 0, 0, -1, 0, 0,
  -3, 0, 0, 1, 0, 0,
  6, 0, 0, -3, 0, 0,
  3, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -7, 0, 0, 0, 0, 0,
  9, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -3, 0, 0, 0, 0, 0,
  -4, 0, 0, 0, 0, 0,
  -5, 0, 0, 3, 0, 0,
  -13, 0, 0, 0, 0, 0,
  -7, 0, 0, 0, 0, 0,
  10, 0, 0, 0, 0, 0,
  3, 0, 0, -1, 0, 0,
  10, 0, 13, 6, 0, -5,
  0, 0, 30, 0, 0, 14,
  0, 0, -162, 0, 0, -138,
  0, 0, 75, 0, 0, 0,
  -7, 0, 0, 4, 0, 0,
  -4, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  5, 0, 0, -2, 0, 0,
  5, 0, 0, -3, 0, 0,
  -3, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -5, 0, 0, 2, 0, 0,
  6, 0, 0, 0, 0, 0,
  9, 0, 0, 0, 0, 0,
  5, 0, 0, 0, 0, 0,
  -7, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -4, 0, 0, 2, 0, 0,
  7, 0, 0, 0, 0, 0,
  -4, 0, 0, 0, 0, 0,
  4, 0, 0, 0, 0, 0,
  -6, 0, -3, 3, 0, 1,
  0, 0, -3, 0, 0, -2,
  11, 0, 0, 0, 0, 0,
  3, 0, 0, -1, 0, 0,
  11, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -1, 0, 3, 3, 0, -1,
  4, 0, 0, -2, 0, 0,
  0, 0, -13, 0, 0, -11,
  3, 0, 6, 0, 0, 0,
  -7, 0, 0, 0, 0, 0,
  5, 0, 0, -3, 0, 0,
  -3, 0, 0, 1, 0, 0,
  3, 0, 0, 0, 0, 0,
  5, 0, 0, -3, 0, 0,
  -7, 0, 0, 3, 0, 0,
  8, 0, 0, -3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  11, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  3, 0, 0, -1, 0, 0,
  -4, 0, 0, 2, 0, 0,
  8, 0, 0, -4, 0, 0,
  3, 0, 0, -1, 0, 0,
  11, 0, 0, 0, 0, 0,
  -6, 0, 0, 3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -8, 0, 0, 4, 0, 0,
  -7, 0, 0, 3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  3, 0, 0, -1, 0, 0,
  6, 0, 0, -3, 0, 0,
  -6, 0, 0, 3, 0, 0,
  6, 0, 0, 0, 0, 0,
  6, 0, 0, -1, 0, 0,
  5, 0, 0, -2, 0, 0,
  -5, 0, 0, 2, 0, 0,
  -4, 0, 0, 0, 0, 0,
  -4, 0, 0, 2, 0, 0,
  4, 0, 0, 0, 0, 0,
  6, 0, 0, -3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  0, 0, -26, 0, 0, -11,
  0, 0, -10, 0, 0, -5,
  5, 0, 0, -3, 0, 0,
  -13, 0, 0, 0, 0, 0,
  3, 0, 0, -2, 0, 0,
  4, 0, 0, -2, 0, 0,
  7, 0, 0, -3, 0, 0,
  4, 0, 0, 0, 0, 0,
  5, 0, 0, 0, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -6, 0, 0, 2, 0, 0,
  -5, 0, 0, 2, 0, 0,
  -7, 0, 0, 3, 0, 0,
  5, 0, 0, -2, 0, 0,
  13, 0, 0, 0, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -3, 0, 0, 0, 0, 0,
  5, 0, 0, -2, 0, 0,
  -11, 0, 0, 0, 0, 0,
  5, 0, 0, -2, 0, 0,
  4, 0, 0, 0, 0, 0,
  4, 0, 0, -2, 0, 0,
  -4, 0, 0, 2, 0, 0,
  6, 0, 0, -3, 0, 0,
  3, 0, 0, -2, 0, 0,
  -12, 0, 0, 0, 0, 0,
  4, 0, 0, 0, 0, 0,
  -3, 0, 0, 0, 0, 0,
  -4, 0, 0, 0, 0, 0,
  3, 0, 0, 0, 0, 0,
  3, 0, 0, -1, 0, 0,
  -3, 0, 0, 1, 0, 0,
  0, 0, -5, 0, 0, -2,
  -7, 0, 0, 4, 0, 0,
  6, 0, 0, -3, 0, 0,
  -3, 0, 0, 0, 0, 0,
  5, 0, 0, -3, 0, 0,
  3, 0, 0, -1, 0, 0,
  3, 0, 0, 0, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -5, 0, 0, 3, 0, 0,
  -3, 0, 0, 2, 0, 0,
  -3, 0, 0, 2, 0, 0,
  12, 0, 0, 0, 0, 0,
  3, 0, 0, -1, 0, 0,
  -4, 0, 0, 2, 0, 0,
  4, 0, 0, 0, 0, 0,
  6, 0, 0, 0, 0, 0,
  5, 0, 0, -3, 0, 0,
  4, 0, 0, -2, 0, 0,
  -6, 0, 0, 3, 0, 0,
  4, 0, 0, -2, 0, 0,
  6, 0, 0, -3, 0, 0,
  6, 0, 0, 0, 0, 0,
  -6, 0, 0, 3, 0, 0,
  3, 0, 0, -2, 0, 0,
  7, 0, 0, -4, 0, 0,
  4, 0, 0, -2, 0, 0,
  -5, 0, 0, 2, 0, 0,
  5, 0, 0, 0, 0, 0,
  -6, 0, 0, 3, 0, 0,
  -6, 0, 0, 3, 0, 0,
  -4, 0, 0, 2, 0, 0,
  10, 0, 0, 0, 0, 0,
  -4, 0, 0, 2, 0, 0,
  7, 0, 0, 0, 0, 0,
  7, 0, 0, -3, 0, 0,
  4, 0, 0, 0, 0, 0,
  11, 0, 0, 0, 0, 0,
  5, 0, 0, -2, 0, 0,
  -6, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  3, 0, 0, -2, 0, 0,
  5, 0, 0, -2, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -4, 0, 0, 2, 0, 0,
  -3, 0, 0, 2, 0, 0,
  4, 0, 0, -2, 0, 0,
  3, 0, 0, -1, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -3, 0, 0, 1, 0, 0,
  -3, 0, 0, 2, 0, 0,
  };
}
