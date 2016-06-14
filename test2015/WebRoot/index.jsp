<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function rhex(a)
{

    var b = "0123456789abcdef";
    str = "";
    for (j = 0; j <= 3; j++) {
        str += b.charAt((a >> (j * 8 + 4)) & 15) + b.charAt((a >> (j * 8)) & 15)
    }
    return str
}
function str2blks_MD5(a)
{
    nblk = ((a.length + 8) >> 6) + 1;
    blks = new Array(nblk * 16);
    for (i = 0; i < nblk * 16; i++) {
        blks[i] = 0
    }
    for (i = 0; i < a.length; i++) {
        blks[i >> 2] |= a.charCodeAt(i) << ((i % 4) * 8)
    }
    blks[i >> 2] |= 128 << ((i % 4) * 8);
    blks[nblk * 16 - 2] = a.length * 8;
    return blks
}
function add(a, d)
{
    var c = (a & 65535) + (d & 65535);
    var b = (a >> 16) + (d >> 16) + (c >> 16);
    return (b << 16) | (c & 65535)
}
function rol(a, b)
{
    return (a << b) | (a >>> (32 - b))
}
function cmn(h, e, d, c, g, f)
{
    return add(rol(add(add(e, h), add(c, f)), g), d)
}
function ff(g, f, m, l, e, k, h)
{
    return cmn((f & m) | ((~f) & l), g, f, e, k, h)
}
function gg(g, f, m, l, e, k, h)
{
    return cmn((f & l) | (m & (~l)), g, f, e, k, h)
}
function hh(g, f, m, l, e, k, h)
{
    return cmn(f^m^l, g, f, e, k, h)
}
function ii(g, f, m, l, e, k, h)
{
    return cmn(m^(f | (~l)), g, f, e, k, h)
}

function MD5(n)
{
    var q = n;
    var n = "";
    for (var g = 0; g < q.length; g++) {
        n += q.charCodeAt(g) + ""
    }
    alert(n);
    x = str2blks_MD5(n);
    alert(x);
    var p = 1732584193;
    var o =- 271733879;
    var m =- 1732584194;
    var l = 271733878;
    for (g = 0; g < x.length; g += 16)
    {
        var k = p;
        var h = o;
        var f = m;
        var e = l;
        p = ff(p, o, m, l, x[g + 0], 7, - 680876936);
        l = ff(l, p, o, m, x[g + 1], 12, - 389564586);
        m = ff(m, l, p, o, x[g + 2], 17, 606105819);
        o = ff(o, m, l, p, x[g + 3], 22, - 1044525330);
        p = ff(p, o, m, l, x[g + 4], 7, - 176418897);
        l = ff(l, p, o, m, x[g + 5], 12, 1200080426);
        m = ff(m, l, p, o, x[g + 6], 17, - 1473231341);
        o = ff(o, m, l, p, x[g + 7], 22, - 45705983);
        p = ff(p, o, m, l, x[g + 8], 7, 1770035416);
        l = ff(l, p, o, m, x[g + 9], 12, - 1958414417);
        m = ff(m, l, p, o, x[g + 10], 17, - 42063);
        o = ff(o, m, l, p, x[g + 11], 22, - 1990404162);
        p = ff(p, o, m, l, x[g + 12], 7, 1804603682);
        l = ff(l, p, o, m, x[g + 13], 12, - 40341101);
        m = ff(m, l, p, o, x[g + 14], 17, - 1502002290);
        o = ff(o, m, l, p, x[g + 15], 22, 1236535329);
        p = gg(p, o, m, l, x[g + 1], 5, - 165796510);
        l = gg(l, p, o, m, x[g + 6], 9, - 1069501632);
        m = gg(m, l, p, o, x[g + 11], 14, 643717713);
        o = gg(o, m, l, p, x[g + 0], 20, - 373897302);
        p = gg(p, o, m, l, x[g + 5], 5, - 701558691);
        l = gg(l, p, o, m, x[g + 10], 9, 38016083);
        m = gg(m, l, p, o, x[g + 15], 14, - 660478335);
        o = gg(o, m, l, p, x[g + 4], 20, - 405537848);
        p = gg(p, o, m, l, x[g + 9], 5, 568446438);
        l = gg(l, p, o, m, x[g + 14], 9, - 1019803690);
        m = gg(m, l, p, o, x[g + 3], 14, - 187363961);
        o = gg(o, m, l, p, x[g + 8], 20, 1163531501);
        p = gg(p, o, m, l, x[g + 13], 5, - 1444681467);
        l = gg(l, p, o, m, x[g + 2], 9, - 51403784);
        m = gg(m, l, p, o, x[g + 7], 14, 1735328473);
        o = gg(o, m, l, p, x[g + 12], 20, - 1926607734);
        p = hh(p, o, m, l, x[g + 5], 4, - 378558);
        l = hh(l, p, o, m, x[g + 8], 11, - 2022574463);
        m = hh(m, l, p, o, x[g + 11], 16, 1839030562);
        o = hh(o, m, l, p, x[g + 14], 23, - 35309556);
        p = hh(p, o, m, l, x[g + 1], 4, - 1530992060);
        l = hh(l, p, o, m, x[g + 4], 11, 1272893353);
        m = hh(m, l, p, o, x[g + 7], 16, - 155497632);
        o = hh(o, m, l, p, x[g + 10], 23, - 1094730640);
        p = hh(p, o, m, l, x[g + 13], 4, 681279174);
        l = hh(l, p, o, m, x[g + 0], 11, - 358537222);
        m = hh(m, l, p, o, x[g + 3], 16, - 722521979);
        o = hh(o, m, l, p, x[g + 6], 23, 76029189);
        p = hh(p, o, m, l, x[g + 9], 4, - 640364487);
        l = hh(l, p, o, m, x[g + 12], 11, - 421815835);
        m = hh(m, l, p, o, x[g + 15], 16, 530742520);
        o = hh(o, m, l, p, x[g + 2], 23, - 995338651);
        p = ii(p, o, m, l, x[g + 0], 6, - 198630844);
        l = ii(l, p, o, m, x[g + 7], 10, 1126891415);
        m = ii(m, l, p, o, x[g + 14], 15, - 1416354905);
        o = ii(o, m, l, p, x[g + 5], 21, - 57434055);
        p = ii(p, o, m, l, x[g + 12], 6, 1700485571);
        l = ii(l, p, o, m, x[g + 3], 10, - 1894986606);
        m = ii(m, l, p, o, x[g + 10], 15, - 1051523);
        o = ii(o, m, l, p, x[g + 1], 21, - 2054922799);
        p = ii(p, o, m, l, x[g + 8], 6, 1873313359);
        l = ii(l, p, o, m, x[g + 15], 10, - 30611744);
        m = ii(m, l, p, o, x[g + 6], 15, - 1560198380);
        o = ii(o, m, l, p, x[g + 13], 21, 1309151649);
        p = ii(p, o, m, l, x[g + 4], 6, - 145523070);
        l = ii(l, p, o, m, x[g + 11], 10, - 1120210379);
        m = ii(m, l, p, o, x[g + 2], 15, 718787259);
        o = ii(o, m, l, p, x[g + 9], 21, - 343485551);
        p = add(p, k);
        o = add(o, h);
        m = add(m, f);
        l = add(l, e)
    }
    alert( rhex(p) + rhex(o) + rhex(m) + rhex(l));
};
	
	</script>
  </head>
  
  <body>
    This is my JSP page. 
    <input type="button" onclick="MD5('a');" />
    <br>
  </body>
</html>
