// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/LexerColor.flex

import compilerTools.TextColor;
import java.awt.Color;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class LexerColor {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\12\0\1\1\2\2\1\3\23\0\1\4\1\5\1\6"+
    "\1\5\1\7\1\10\1\11\2\5\1\12\1\13\1\5"+
    "\1\14\1\5\1\15\1\16\1\17\1\20\7\17\1\0"+
    "\1\5\1\21\1\22\1\23\2\0\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\2\27\1\32\2\27\1\33\1\27"+
    "\1\34\1\35\1\36\1\27\1\37\1\40\1\27\1\41"+
    "\1\42\4\27\1\5\1\0\1\5\1\0\1\27\1\0"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\2\27\1\54\1\55\1\56\1\57\1\60\1\27"+
    "\1\61\1\62\1\63\1\64\1\65\1\27\1\66\1\27"+
    "\1\67\1\5\1\70\1\5\7\0\1\2\73\0\1\27"+
    "\7\0\1\27\3\0\1\27\3\0\1\27\1\0\1\27"+
    "\6\0\1\27\1\0\1\27\4\0\1\27\7\0\1\27"+
    "\3\0\1\27\3\0\1\27\1\0\1\27\6\0\1\27"+
    "\1\0\1\27\u012b\0\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\3\1\1\2\4\1\1\3\33\1"+
    "\1\4\2\0\1\2\1\3\4\1\1\5\37\1\1\5"+
    "\2\1\5\6\47\1\1\6\34\1\1\5\26\1\1\7"+
    "\6\1\1\5\12\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[198];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\162\0\71\0\253\0\344\0\u011d\0\u0156"+
    "\0\u018f\0\u01c8\0\u0201\0\u023a\0\u0273\0\u02ac\0\u02e5\0\u031e"+
    "\0\u0357\0\u0390\0\u03c9\0\u0402\0\u043b\0\u0474\0\u04ad\0\u04e6"+
    "\0\u051f\0\u0558\0\u0591\0\u05ca\0\u0603\0\u063c\0\u0675\0\u06ae"+
    "\0\u06e7\0\u0720\0\u0759\0\u0792\0\u07cb\0\u0804\0\u083d\0\u0876"+
    "\0\u08af\0\u0273\0\u08e8\0\u0921\0\u095a\0\u0993\0\u09cc\0\u0a05"+
    "\0\u0a3e\0\u031e\0\u0a77\0\u0ab0\0\u0ae9\0\u0b22\0\u0b5b\0\u0b94"+
    "\0\u0bcd\0\u0c06\0\u0c3f\0\u0c78\0\u0cb1\0\u0cea\0\u0d23\0\u0d5c"+
    "\0\u0d95\0\u0dce\0\u0e07\0\u0e40\0\u0e79\0\u0eb2\0\u0eeb\0\u0f24"+
    "\0\u0f5d\0\u0f96\0\u0fcf\0\u1008\0\u1041\0\u107a\0\u10b3\0\u10ec"+
    "\0\u1125\0\u115e\0\u1197\0\u11d0\0\71\0\u0921\0\u08e8\0\u1209"+
    "\0\u1242\0\u127b\0\u12b4\0\u12ed\0\u1326\0\u135f\0\u1398\0\u13d1"+
    "\0\u140a\0\u1443\0\u147c\0\u14b5\0\u14ee\0\u1527\0\u1560\0\u1599"+
    "\0\u15d2\0\u160b\0\u1644\0\u167d\0\u16b6\0\u16ef\0\u1728\0\u1761"+
    "\0\u179a\0\u17d3\0\u180c\0\u1845\0\u187e\0\u18b7\0\u18f0\0\u1929"+
    "\0\u1962\0\u199b\0\u19d4\0\u1a0d\0\u1a46\0\u1a7f\0\u1ab8\0\u1af1"+
    "\0\u1b2a\0\u1b63\0\u1b9c\0\u1bd5\0\u1c0e\0\u1c47\0\u1c80\0\u1cb9"+
    "\0\u1cf2\0\u1d2b\0\u1d64\0\u1d9d\0\u1dd6\0\u1e0f\0\u1e48\0\u1e81"+
    "\0\u1eba\0\u1ef3\0\u1f2c\0\u1f65\0\u1f9e\0\u1fd7\0\u2010\0\u2049"+
    "\0\u2082\0\u20bb\0\u20f4\0\u212d\0\u2166\0\u219f\0\u21d8\0\u2211"+
    "\0\u224a\0\u2283\0\u22bc\0\u22f5\0\u232e\0\u2367\0\u23a0\0\u23d9"+
    "\0\u2412\0\u244b\0\u2484\0\u24bd\0\u24f6\0\u252f\0\u2568\0\u25a1"+
    "\0\u25da\0\u2613\0\u115e\0\u264c\0\u031e\0\u2685\0\u26be\0\u26f7"+
    "\0\u2730\0\u2769\0\u27a2\0\u27db\0\u2814\0\u284d\0\u2886\0\u28bf"+
    "\0\u28f8\0\u2931\0\u296a\0\u29a3\0\u29dc\0\u2a15";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[198];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\3\0\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\3\15\1\16\1\3\1\17"+
    "\1\20\1\21\1\22\1\20\1\23\1\24\1\25\3\20"+
    "\1\26\3\20\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\20\1\43"+
    "\1\44\1\45\1\46\1\47\4\20\1\50\113\0\1\4"+
    "\72\0\44\51\10\0\1\4\71\0\1\4\73\0\2\4"+
    "\66\0\1\4\71\0\1\4\2\0\1\52\2\15\64\0"+
    "\1\4\1\0\1\52\2\15\50\0\15\53\1\54\53\53"+
    "\1\55\3\0\65\55\21\0\2\4\70\0\2\4\63\0"+
    "\3\20\3\0\44\20\17\0\3\20\3\0\33\20\1\56"+
    "\10\20\17\0\3\20\3\0\7\20\1\57\7\20\1\60"+
    "\24\20\17\0\3\20\3\0\32\20\1\61\5\20\1\62"+
    "\3\20\17\0\3\20\3\0\6\20\1\63\6\20\1\64"+
    "\12\20\1\65\13\20\17\0\3\20\3\0\10\20\1\66"+
    "\33\20\17\0\3\20\3\0\27\20\1\62\14\20\17\0"+
    "\3\20\3\0\1\67\43\20\17\0\3\20\3\0\21\20"+
    "\1\70\14\20\1\71\5\20\17\0\3\20\3\0\40\20"+
    "\1\72\3\20\17\0\3\20\3\0\17\20\1\73\13\20"+
    "\1\74\4\20\1\75\3\20\17\0\3\20\3\0\23\20"+
    "\1\76\3\20\1\77\14\20\17\0\3\20\3\0\30\20"+
    "\1\100\1\20\1\101\7\20\1\102\1\20\17\0\3\20"+
    "\3\0\23\20\1\103\20\20\17\0\3\20\3\0\40\20"+
    "\1\104\3\20\17\0\3\20\3\0\17\20\1\105\24\20"+
    "\17\0\3\20\3\0\31\20\1\106\1\107\11\20\17\0"+
    "\3\20\3\0\23\20\1\110\7\20\1\111\10\20\17\0"+
    "\3\20\3\0\17\20\1\112\7\20\1\113\3\20\1\114"+
    "\10\20\17\0\3\20\3\0\35\20\1\115\6\20\17\0"+
    "\3\20\3\0\17\20\1\116\15\20\1\117\6\20\17\0"+
    "\3\20\3\0\17\20\1\120\3\20\1\121\20\20\17\0"+
    "\3\20\3\0\27\20\1\122\10\20\1\123\3\20\17\0"+
    "\3\20\3\0\23\20\1\124\20\20\71\0\1\4\16\0"+
    "\3\51\3\0\44\51\1\0\15\53\1\125\53\53\1\126"+
    "\1\127\1\126\1\130\11\126\1\131\53\126\16\0\3\55"+
    "\66\0\3\20\3\0\33\20\1\132\10\20\17\0\3\20"+
    "\3\0\1\133\43\20\17\0\3\20\3\0\22\20\1\134"+
    "\12\20\1\135\6\20\17\0\3\20\3\0\37\20\1\136"+
    "\4\20\17\0\3\20\3\0\10\20\1\62\33\20\17\0"+
    "\3\20\3\0\10\20\1\137\33\20\17\0\3\20\3\0"+
    "\33\20\1\140\10\20\17\0\3\20\3\0\6\20\1\141"+
    "\35\20\17\0\3\20\3\0\13\20\1\62\30\20\17\0"+
    "\3\20\3\0\37\20\1\142\4\20\17\0\3\20\3\0"+
    "\21\20\1\62\22\20\17\0\3\20\3\0\36\20\1\143"+
    "\5\20\17\0\3\20\3\0\31\20\1\144\4\20\1\145"+
    "\1\146\4\20\17\0\3\20\3\0\32\20\1\147\2\20"+
    "\1\150\6\20\17\0\3\20\3\0\23\20\1\151\20\20"+
    "\17\0\3\20\3\0\21\20\1\152\14\20\1\153\5\20"+
    "\17\0\3\20\3\0\41\20\1\154\2\20\17\0\3\20"+
    "\3\0\27\20\1\155\14\20\17\0\3\20\3\0\37\20"+
    "\1\156\4\20\17\0\3\20\3\0\34\20\1\157\7\20"+
    "\17\0\3\20\3\0\21\20\1\160\22\20\17\0\3\20"+
    "\3\0\17\20\1\161\24\20\17\0\3\20\3\0\21\20"+
    "\1\110\22\20\17\0\3\20\3\0\34\20\1\162\7\20"+
    "\17\0\3\20\3\0\37\20\1\163\4\20\17\0\3\20"+
    "\3\0\23\20\1\164\20\20\17\0\3\20\3\0\25\20"+
    "\1\165\16\20\17\0\3\20\3\0\42\20\1\166\1\20"+
    "\17\0\3\20\3\0\23\20\1\167\6\20\1\166\11\20"+
    "\17\0\3\20\3\0\36\20\1\170\5\20\17\0\3\20"+
    "\3\0\22\20\1\171\21\20\17\0\3\20\3\0\35\20"+
    "\1\172\6\20\17\0\3\20\3\0\33\20\1\173\10\20"+
    "\17\0\3\20\3\0\27\20\1\174\14\20\17\0\3\20"+
    "\3\0\22\20\1\175\13\20\1\176\1\177\4\20\17\0"+
    "\3\20\3\0\32\20\1\145\11\20\17\0\3\20\3\0"+
    "\31\20\1\200\12\20\17\0\3\20\3\0\42\20\1\150"+
    "\1\20\1\0\1\53\1\127\13\53\1\125\53\53\1\131"+
    "\1\125\1\131\1\201\65\131\16\0\3\20\3\0\30\20"+
    "\1\202\13\20\17\0\3\20\3\0\14\20\1\203\27\20"+
    "\17\0\3\20\3\0\23\20\1\204\20\20\17\0\3\20"+
    "\3\0\17\20\1\205\24\20\17\0\3\20\3\0\23\20"+
    "\1\206\20\20\17\0\3\20\3\0\2\20\1\207\41\20"+
    "\17\0\3\20\3\0\37\20\1\210\4\20\17\0\3\20"+
    "\3\0\2\20\1\211\41\20\17\0\3\20\3\0\40\20"+
    "\1\212\3\20\17\0\3\20\3\0\21\20\1\200\22\20"+
    "\17\0\3\20\3\0\20\20\1\213\23\20\17\0\3\20"+
    "\3\0\33\20\1\62\10\20\17\0\3\20\3\0\23\20"+
    "\1\214\20\20\17\0\3\20\3\0\21\20\1\215\22\20"+
    "\17\0\3\20\3\0\37\20\1\145\4\20\17\0\3\20"+
    "\3\0\32\20\1\216\11\20\17\0\3\20\3\0\27\20"+
    "\1\217\14\20\17\0\3\20\3\0\21\20\1\62\17\20"+
    "\1\220\2\20\17\0\3\20\3\0\27\20\1\221\14\20"+
    "\17\0\3\20\3\0\31\20\1\222\12\20\17\0\3\20"+
    "\3\0\23\20\1\223\20\20\17\0\3\20\3\0\33\20"+
    "\1\224\10\20\17\0\3\20\3\0\26\20\1\172\15\20"+
    "\17\0\3\20\3\0\35\20\1\225\6\20\17\0\3\20"+
    "\3\0\33\20\1\224\1\20\1\226\6\20\17\0\3\20"+
    "\3\0\23\20\1\227\20\20\17\0\3\20\3\0\35\20"+
    "\1\62\6\20\17\0\3\20\3\0\27\20\1\230\14\20"+
    "\17\0\3\20\3\0\27\20\1\231\14\20\17\0\3\20"+
    "\3\0\32\20\1\232\11\20\17\0\3\20\3\0\37\20"+
    "\1\233\4\20\17\0\3\20\3\0\23\20\1\234\20\20"+
    "\17\0\3\20\3\0\17\20\1\62\24\20\17\0\3\20"+
    "\3\0\31\20\1\235\12\20\17\0\3\20\3\0\43\20"+
    "\1\236\17\0\3\20\3\0\33\20\1\237\10\20\17\0"+
    "\3\20\3\0\37\20\1\200\4\20\17\0\3\20\3\0"+
    "\33\20\1\240\10\20\17\0\3\20\3\0\17\20\1\164"+
    "\24\20\2\0\1\125\105\0\3\20\3\0\23\20\1\241"+
    "\20\20\17\0\3\20\3\0\4\20\1\62\37\20\17\0"+
    "\3\20\3\0\32\20\1\242\11\20\17\0\3\20\3\0"+
    "\21\20\1\243\22\20\17\0\3\20\3\0\35\20\1\244"+
    "\6\20\17\0\3\20\3\0\6\20\1\245\35\20\17\0"+
    "\3\20\3\0\17\20\1\246\24\20\17\0\3\20\3\0"+
    "\6\20\1\247\35\20\17\0\3\20\3\0\17\20\1\250"+
    "\24\20\17\0\3\20\3\0\27\20\1\145\14\20\17\0"+
    "\3\20\3\0\25\20\1\251\16\20\17\0\3\20\3\0"+
    "\17\20\1\252\24\20\17\0\3\20\3\0\37\20\1\172"+
    "\4\20\17\0\3\20\3\0\31\20\1\253\12\20\17\0"+
    "\3\20\3\0\27\20\1\254\14\20\17\0\3\20\3\0"+
    "\22\20\1\255\21\20\17\0\3\20\3\0\27\20\1\234"+
    "\14\20\17\0\3\20\3\0\35\20\1\256\6\20\17\0"+
    "\3\20\3\0\35\20\1\176\6\20\17\0\3\20\3\0"+
    "\22\20\1\200\21\20\17\0\3\20\3\0\27\20\1\257"+
    "\14\20\17\0\3\20\3\0\32\20\1\176\11\20\17\0"+
    "\3\20\3\0\21\20\1\145\22\20\17\0\3\20\3\0"+
    "\31\20\1\145\12\20\17\0\3\20\3\0\37\20\1\260"+
    "\4\20\17\0\3\20\3\0\35\20\1\200\6\20\17\0"+
    "\3\20\3\0\32\20\1\200\11\20\17\0\3\20\3\0"+
    "\23\20\1\261\20\20\17\0\2\20\1\62\3\0\44\20"+
    "\17\0\3\20\3\0\32\20\1\262\11\20\17\0\3\20"+
    "\3\0\35\20\1\263\6\20\17\0\3\20\3\0\17\20"+
    "\1\264\24\20\17\0\3\20\3\0\17\20\1\265\24\20"+
    "\17\0\3\20\3\0\37\20\1\266\4\20\17\0\3\20"+
    "\3\0\33\20\1\265\10\20\17\0\3\20\3\0\11\20"+
    "\1\63\32\20\17\0\3\20\3\0\32\20\1\267\11\20"+
    "\17\0\3\20\3\0\11\20\1\62\32\20\17\0\3\20"+
    "\3\0\30\20\1\270\13\20\17\0\3\20\3\0\33\20"+
    "\1\271\10\20\17\0\3\20\3\0\37\20\1\171\4\20"+
    "\17\0\3\20\3\0\17\20\1\272\24\20\17\0\3\20"+
    "\3\0\17\20\1\273\24\20\17\0\3\20\3\0\27\20"+
    "\1\164\14\20\17\0\3\20\3\0\33\20\1\274\10\20"+
    "\17\0\3\20\3\0\31\20\1\255\12\20\17\0\3\20"+
    "\3\0\35\20\1\275\6\20\17\0\3\20\3\0\22\20"+
    "\1\213\21\20\17\0\3\20\3\0\22\20\1\276\21\20"+
    "\17\0\3\20\3\0\32\20\1\244\11\20\17\0\3\20"+
    "\3\0\23\20\1\277\20\20\17\0\3\20\3\0\37\20"+
    "\1\300\4\20\17\0\3\20\3\0\27\20\1\301\14\20"+
    "\17\0\3\20\3\0\35\20\1\302\6\20\17\0\3\20"+
    "\3\0\30\20\1\62\13\20\17\0\3\20\3\0\21\20"+
    "\1\303\22\20\17\0\3\20\3\0\7\20\1\62\34\20"+
    "\17\0\3\20\3\0\17\20\1\304\24\20\17\0\3\20"+
    "\3\0\23\20\1\200\20\20\17\0\3\20\3\0\35\20"+
    "\1\265\6\20\17\0\3\20\3\0\23\20\1\265\20\20"+
    "\17\0\3\20\3\0\43\20\1\200\17\0\3\20\3\0"+
    "\27\20\1\172\14\20\17\0\3\20\3\0\27\20\1\305"+
    "\14\20\17\0\3\20\3\0\36\20\1\62\5\20\17\0"+
    "\3\20\3\0\33\20\1\306\10\20\17\0\3\20\3\0"+
    "\32\20\1\203\11\20\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10830];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\45\1\2\0\51\1\1\11"+
    "\161\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[198];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerColor(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public TextColor yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return textColor(yychar, yylength(), new Color( 255, 0, 0 ));
            }
            // fall through
          case 8: break;
          case 2:
            { switch (yytext()) {
        case "==": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "!=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case ">>": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "<<": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case ">=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "<=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "&&": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "||": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "!": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "\'+": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "\'-": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "++": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "--": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "**": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "//": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "%%": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "(": return textColor (yychar, yylength(), new Color(   200, 227, 0 ));
        case ")": return textColor (yychar, yylength(), new Color(   200, 227, 0 ));
        case "{": return textColor (yychar, yylength(), new Color(   220, 227, 0  ));
        case "}": return textColor (yychar, yylength(), new Color(   220, 227, 0  ));
        case "[": return textColor (yychar, yylength(), new Color(  300, 227, 0 ));
        case "]": return textColor (yychar, yylength(), new Color(  300, 227, 0 ));
        case ".": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case ";": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case ",": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "\"": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "'": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "$": return textColor (yychar, yylength(), new Color(255, 0, 100));
    }
            }
            // fall through
          case 9: break;
          case 3:
            { return textColor(yychar, yylength(), new Color(0, 112, 255));
            }
            // fall through
          case 10: break;
          case 4:
            { return textColor(yychar, yylength(), new Color(  100, 227, 191 ));
            }
            // fall through
          case 11: break;
          case 5:
            { return textColor(yychar, yylength(), new Color(73, 255, 0));
            }
            // fall through
          case 12: break;
          case 6:
            { return textColor(yychar, yylength(), new Color(  142,142,142  ));
            }
            // fall through
          case 13: break;
          case 7:
            { return textColor(yychar, yylength(), new Color(  216, 37, 208  ));
            }
            // fall through
          case 14: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
