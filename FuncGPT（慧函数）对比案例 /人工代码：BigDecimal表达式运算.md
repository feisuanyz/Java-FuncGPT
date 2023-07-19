
```
@MethodDesc(desc="BigDecimal按公式运算,结果四舍五入取N位小数",params= {
            @ParamDesc(name="scaleLen",desc="结果小数位"),
            @ParamDesc(name="middleScaleLen",desc="中间运算除法小数位（传0默认为6位）"),
            @ParamDesc(name="formualText",desc="计算公式(如：A+B/C）,如果出现负数请用下划线代替（例：A+B*-1写成A+B*_1"),
            @ParamDesc(name="varArr",desc="变量名和变量值列表(如：A:90，B:89）"),
    })
    public static BigDecimal bigDecimalFormualCalc(int scaleLen, int middleScaleLen, String formualText, Map<String, Object> varArr) {
        int iMiddleScaleLen=6;
        if(middleScaleLen>0){
            iMiddleScaleLen=middleScaleLen;
        }
        Set<String> keySet = varArr.keySet();
        for (String key : keySet) {
            varArr.put(key, varArr.get(key).toString().replace("-", "_"));
        }

        BigDecimal result=null;
        String formualTextStr=formualText;
        String sFormual="";
        String valueTemp="";
        int iLeftBracketIndex=formualTextStr.lastIndexOf(LEFT);
        int iRightBracketIndex=0;
        if(iLeftBracketIndex>=0){
            while (iLeftBracketIndex>=0){
                iRightBracketIndex=formualTextStr.indexOf(RIGHT,iLeftBracketIndex);
                sFormual=formualTextStr.substring(iLeftBracketIndex,iRightBracketIndex+1);
                sFormual=sFormual.replace(LEFT, REPLACEMENT);
                sFormual=sFormual.replace(RIGHT,REPLACEMENT);
                result= FloatUtils.oneBigDecimalFormualCalc(middleScaleLen,iMiddleScaleLen,sFormual,varArr);
                valueTemp=result.toString().replace("-","_");
                formualTextStr=formualTextStr.replace(LEFT.concat(sFormual).concat(RIGHT),valueTemp);
                iLeftBracketIndex=formualTextStr.lastIndexOf(LEFT);
            }
        }

        result=FloatUtils.oneBigDecimalFormualCalc(scaleLen,iMiddleScaleLen,formualTextStr,varArr);
        return  result;
    }
	
	
	public class FloatUtils {
    private FloatUtils(){}
    public static BigDecimal oneBigDecimalFormualCalc(int scaleLen, int middleScaleLen,
                                                      String oneFormualText, Map<String, Object> varArr) {

        BigDecimal result=null;
        String formualTextStr=oneFormualText;
        String linkStr="";

        Set<String> keySet = varArr.keySet();
        for (String key : keySet) {
            formualTextStr = formualTextStr.replace(key, varArr.get(key).toString());
        }
        char c ;
        List<Character> chars = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        String oneValue="";
        chars.add('+');
        chars.add('-');
        chars.add('*');
        chars.add('/');
        boolean isFindedLink=false;
        while (formualTextStr.length()>0) {
            isFindedLink=false;
            for (int i = 0; i < formualTextStr.length(); i++) {
                c = formualTextStr.charAt(i);
                if (chars.contains(c)) {
                    linkStr = linkStr.concat(String.valueOf(c));
                    oneValue = formualTextStr.substring(0, i);
                    oneValue=oneValue.replace("_","-");
                    formualTextStr = formualTextStr.substring(i+1, formualTextStr.length());
                    valueList.add(oneValue);
                    isFindedLink=true;
                    break;
                }
            }
            if(!isFindedLink){
                formualTextStr=formualTextStr.replace("_","-");
                valueList.add(formualTextStr);
                formualTextStr="";
            }
        }
        BigDecimal[] valueArr=new BigDecimal[valueList.size()];
        for(int i=0;i<valueList.size();i++){
            valueArr[i]=new BigDecimal(valueList.get(i).toString());
        }

        result= FloatFunction.bigDecimalValueCalc2(scaleLen,middleScaleLen,linkStr,valueArr);
        return  result;
    }


}


@MethodDesc(desc="BigDecimal按值列表运算（中间除法小数位入参控制）,结果四舍五入取N位小数",params= {
            @ParamDesc(name="scaleLen",desc="小数位个数"),
            @ParamDesc(name="middleScaleLen",desc="中间运算除法小数位（传0默认为6位）"),
            @ParamDesc(name="linkArr",desc="运算符列表(如：A+B/C，则传+/）"),
            @ParamDesc(name="valueArr",desc="String值列表(如：A+B/C，则传ABC的3个值）"),})
    public static BigDecimal bigDecimalValueCalc2(int scaleLen, int middleScaleLen,String linkArr,Object[] valueArr) {
        BigDecimal result;
        int iMiddleScaleLen=6;
        if(middleScaleLen>0){
            iMiddleScaleLen=middleScaleLen;
        }
        ArrayList<BigDecimal> valueList=new ArrayList();
        ArrayList linkList=new ArrayList();
        for (int i=0;i<valueArr.length;i++){
            if (valueArr[i] instanceof BigDecimal){
                valueList.add((BigDecimal)valueArr[i]);
            }else if (valueArr[i] instanceof Double){
                valueList.add(BigDecimal.valueOf((double)valueArr[i]));
            }else if (valueArr[i] instanceof Integer){
                valueList.add(BigDecimal.valueOf((int)valueArr[i]));
            }else {
                valueList.add(new BigDecimal(valueArr[i].toString()));
            }
        }
        for (int i=0;i<linkArr.length();i++){
            linkList.add(linkArr.charAt(i));
        }
        String linkStr="";
        BigDecimal valueOne=null;
        BigDecimal valueTwo=null;
        int iIndex=0;
        int multiplyDivideIndex=-1;
        BigDecimal tempValue= BigDecimal.ZERO;
        while (linkList.size()>0){
            multiplyDivideIndex=-1;
            for (int i=0;i<linkList.size();i++) {
                linkStr=linkList.get(i).toString();
                if ("*".equals(linkStr)|| "/".equals(linkStr)) {
                    multiplyDivideIndex = i;
                    break;
                }
            }
            if(multiplyDivideIndex<0) {
                iIndex=0;
            }
            else {
                iIndex=multiplyDivideIndex;
            }
            linkStr=linkList.get(iIndex).toString();
            valueOne=valueList.get(iIndex);
            valueTwo=valueList.get(iIndex+1);
            switch (linkStr) {
                case "+":
                    tempValue=valueOne.add(valueTwo);
                    break;
                case "-":
                    tempValue=valueOne.subtract(valueTwo);
                    break;
                case "*":
                    tempValue=valueOne.multiply(valueTwo);
                    break;
                case "/":
                    tempValue=valueOne.divide(valueTwo,iMiddleScaleLen,BigDecimal.ROUND_HALF_UP);
                    break;
                default:
                    break;
            }
            valueList.remove(iIndex);
            valueList.remove(iIndex);
            valueList.add(iIndex,tempValue);
            linkList.remove(iIndex);
        }
        if (scaleLen<0){
            result=valueList.get(0);
        } else {
            result=valueList.get(0).setScale(scaleLen,BigDecimal.ROUND_HALF_UP);
        }
        return  result;
    }
```
