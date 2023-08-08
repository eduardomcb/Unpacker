package com.eduardomcb.unpacker

fun main(args: Array<String>) {
    val packed1 = "eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\\\b'+e(c)+'\\\\b','g'),k[c]);return p}('a 0,1;c=3(){0=6.7(\"0\");1=6.7(\"1\");5(8)};3 9(){1.2=b(0.2)}3 5(4){1.2=0.2=\"\";d(4){0.4()}}',14,14,'input|output|value|function|focus|clearAll|document|getElementById|true|packScript|var|pack|onload|if'.split('|'),0,{}))"
    val packed2 = "eval(function(p,a,c,k,e,r){e=String;if(!''.replace(/^/,String)){while(c--)r[c]=k[c]||c;k=[function(e){return r[e]}];e=function(){return'\\\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\\\b'+e(c)+'\\\\b','g'),k[c]);return p}('(0(){4 1=\"5 6 7 8\";0 2(3){9(3)}2(1)})();',10,10,'function|b|something|a|var|some|sample|packed|code|alert'.split('|'),0,{}))"

    val unpacker = Unpacker()

    //If you want to detect earlier, use: unpacker.detect(source)

    println(unpacker.unpack(packed1))
}