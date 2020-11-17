<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html>
	<body>
		<h2>Órarend</h2>
		<table border="1">
			<tr bgcolor="blue">
				<th>ID</th>
				<th>Típus</th>
				<th>Tantárgy</th>
				<th>Nap</th>
				<th>Tól</th>
				<th>Ig</th>
				<th>Helyszín</th>
				<th>Oktató</th>
				<th>Szak</th>
			</tr>
     		<xsl:for-each select="órarend/óra">
        		<tr>
       	  			<td><xsl:value-of select="@id"/></td>
          			<td><xsl:value-of select="@tipus"/></td>
          			<td><xsl:value-of select="tárgy"/></td>
          			<td><xsl:value-of select="időpont/nap"/></td>
          			<td><xsl:value-of select="időpont/tól"/></td>
          			<td><xsl:value-of select="időpont/ig"/></td>
          			<td><xsl:value-of select="helyszín"/></td>
          			<td><xsl:value-of select="oktató"/></td>
          			<td><xsl:value-of select="szak"/></td>
        		</tr>
      		</xsl:for-each>
    	</table>
  	</body>
  	</html>
</xsl:template>

</xsl:stylesheet> 