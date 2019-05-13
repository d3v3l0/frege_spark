/*
  Source code is in UTF-8 encoding. The following symbols may appear, among others:
  α β γ δ ε ζ η θ ι κ λ μ ν ξ ο π ρ ς σ τ υ φ χ ψ ω « • ¦ » ∀ ∃ ∷ … → ← ﬁ ﬂ ƒ
  If you can't read this, you're out of luck. This code was generated with the frege compiler version 3.25.84
  from src/main/frege/computations/FregeFunction.fr Do not edit this file! Instead, edit the source file and recompile.
*/

package numbers;

import frege.run8.Func;
import frege.run8.Lazy;
import frege.run8.Thunk;
import frege.run.Kind;
import frege.run.RunTM;
import frege.runtime.Meta;
import frege.runtime.Phantom.RealWorld;
import frege.Prelude;
import frege.control.Category;
import frege.control.Semigroupoid;
import frege.data.Bits;
import frege.data.Char;
import frege.data.Foldable;
import frege.data.List;
import frege.data.Monoid;
import frege.data.Traversable;
import frege.data.TreeMap;
import frege.data.wrapper.Const;
import frege.data.wrapper.Dual;
import frege.data.wrapper.Endo;
import frege.data.wrapper.Identity;
import frege.data.wrapper.Num;
import frege.java.IO;
import frege.java.Lang;
import frege.java.Util;
import frege.java.util.Regex;
import frege.prelude.Maybe;
import frege.prelude.PreludeArrays;
import frege.prelude.PreludeBase;
import frege.prelude.PreludeDecimal;
import frege.prelude.PreludeIO;
import frege.prelude.PreludeList;
import frege.prelude.PreludeMonad;
import frege.prelude.PreludeText;
import frege.system.Random;
import frege.test.QuickCheck;
import frege.test.QuickCheckArbitrary;
import frege.test.QuickCheckException;
import frege.test.QuickCheckGen;
import frege.test.QuickCheckModifiers;
import frege.test.QuickCheckProperty;
import frege.test.QuickCheckState;
import frege.test.QuickCheckTest;
import frege.test.QuickCheckText;

@SuppressWarnings("unused")
@Meta.FregePackage(
  source="src/main/frege/computations/FregeFunction.fr", time=1556090440477L, jmajor=1, jminor=8,
  imps={
    "model.DataSet", "frege.Prelude", "frege.prelude.PreludeArrays", "frege.prelude.PreludeBase",
    "frege.prelude.PreludeDecimal", "frege.prelude.PreludeIO", "frege.prelude.PreludeList",
    "frege.prelude.PreludeMonad", "frege.prelude.PreludeText", "frege.test.QuickCheck", "frege.java.util.Regex"
  },
  nmss={
    "DataSet", "Prelude", "PreludeArrays", "PreludeBase", "PreludeDecimal", "PreludeIO", "PreludeList",
    "PreludeMonad", "PreludeText", "QuickCheck", "Regexp"
  },
  symas={}, symcs={}, symis={}, symts={},
  symvs={
    @Meta.SymV(
      offset=93, name=@Meta.QName(pack="computations.FregeFunction", base="myNumber"), stri="s",
      sig=0, depth=0, rkind=13
    ),
    @Meta.SymV(
      offset=1076, name=@Meta.QName(pack="computations.FregeFunction", base="mapGetTemperatureFromStringArray"),
      stri="s(s)", sig=2, depth=1, rkind=13
    ),
    @Meta.SymV(
      offset=837, name=@Meta.QName(pack="computations.FregeFunction", base="mapGetTemperature"), stri="s(s)",
      sig=4, depth=1, rkind=13
    ),
    @Meta.SymV(
      offset=1363, name=@Meta.QName(pack="computations.FregeFunction", base="getSum"), stri="s(s)",
      sig=6, depth=1, rkind=45
    ),
    @Meta.SymV(
      offset=146, name=@Meta.QName(pack="computations.FregeFunction", base="filterThreeOrFive"), stri="s(s)",
      sig=7, depth=1, rkind=13
    ),
    @Meta.SymV(
      offset=467, name=@Meta.QName(pack="computations.FregeFunction", base="filterHighRainFromStringArray"),
      stri="s(s)", sig=8, depth=1, rkind=13
    ),
    @Meta.SymV(
      offset=269, name=@Meta.QName(pack="computations.FregeFunction", base="filterHighRain"), stri="s(s)",
      sig=9, depth=1, rkind=13
    )
  },
  symls={},
  taus={
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="frege.prelude.PreludeBase", base="Double")}),
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="frege.prelude.PreludeBase", base="[]")}),
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="frege.prelude.PreludeBase", base="StringJ")}),
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="frege.prelude.PreludeBase", base="Char")}),
    @Meta.Tau(kind=0, suba=2, subb=3), @Meta.Tau(kind=0, suba=1, subb=4),
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="model.DataSet", base="DataSet")}),
    @Meta.Tau(kind=0, suba=1, subb=0),
    @Meta.Tau(kind=2, suba=0, tcon={@Meta.QName(kind=0, pack="frege.prelude.PreludeBase", base="Bool")})
  },
  rhos={
    @Meta.Rho(rhofun=false, rhotau=0), @Meta.Rho(rhofun=false, rhotau=5), @Meta.Rho(sigma=1, rhotau=0),
    @Meta.Rho(rhofun=false, rhotau=6), @Meta.Rho(sigma=3, rhotau=0), @Meta.Rho(rhofun=false, rhotau=7),
    @Meta.Rho(sigma=5, rhotau=0), @Meta.Rho(rhofun=false, rhotau=8), @Meta.Rho(sigma=0, rhotau=7),
    @Meta.Rho(sigma=1, rhotau=7), @Meta.Rho(sigma=3, rhotau=7)
  },
  sigmas={
    @Meta.Sigma(rho=0), @Meta.Sigma(rho=1), @Meta.Sigma(rho=2), @Meta.Sigma(rho=3), @Meta.Sigma(rho=4),
    @Meta.Sigma(rho=5), @Meta.Sigma(rho=6), @Meta.Sigma(rho=8), @Meta.Sigma(rho=9), @Meta.Sigma(rho=10)
  },
  exprs={@Meta.Expr()}
)
final public class FregeFunction  {
  




final public static double myNumber = 4.0D;
final public static double mapGetTemperatureFromStringArray(final PreludeBase.TList<String/*<Character>*/> arg$1) {
  final PreludeBase.TEither<java.lang.NumberFormatException, Double> $11247 = PreludeBase.TStringJ.$double(
        PreludeList.<String/*<Character>*/>$excl$excl(arg$1, 10)
      );
  final PreludeBase.TEither.DLeft<java.lang.NumberFormatException, Double> $11248 = $11247
  .asLeft();
  if ($11248 != null) {
    return 0D;
  }
  final PreludeBase.TEither.DRight<java.lang.NumberFormatException, Double> $11249 = $11247
  .asRight();
  assert $11249 != null;
  final double d$11180 = (double)$11249.mem1.call();
  return d$11180;
}

final public static double getSum(final PreludeBase.TList<Double> arg$1) {
  final PreludeBase.TList.DList<Double> $11255 = arg$1.asList();
  if ($11255 != null) {
    return 0D;
  }
  final PreludeBase.TList.DCons<Double> $11256 = arg$1.asCons();
  assert $11256 != null;
  final PreludeBase.TList<Double> xs$11183 = $11256.mem2.call();
  final double x$11182 = (double)$11256.mem1.call();
  return x$11182 + FregeFunction.getSum(xs$11183);
}
final public static boolean filterThreeOrFive(final double arg$1) {
  if (3.0D == arg$1) {
    return true;
  }
  if (5.0D == arg$1) {
    return true;
  }
  return false;
}
final public static boolean filterHighRainFromStringArray(final PreludeBase.TList<String/*<Character>*/> arg$1) {
  final PreludeBase.TEither<java.lang.NumberFormatException, Double> $11259 = PreludeBase.TStringJ.$double(
        PreludeList.<String/*<Character>*/>$excl$excl(arg$1, 9)
      );
  final PreludeBase.TEither.DLeft<java.lang.NumberFormatException, Double> $11260 = $11259
  .asLeft();
  if ($11260 != null) {
    return false;
  }
  final PreludeBase.TEither.DRight<java.lang.NumberFormatException, Double> $11261 = $11259
  .asRight();
  assert $11261 != null;
  final double d$11175 = (double)$11261.mem1.call();
  return d$11175 > 5D;
}
public static class K  {
  final public static java.math.BigInteger big5 = new java.math.BigInteger("5");
}
}