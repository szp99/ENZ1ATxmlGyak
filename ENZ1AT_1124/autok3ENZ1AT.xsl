<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xsl:template match="/">
	<xsl:copy>
		<xsl:element name="db">
			<xsl:value-of select="count(//auto)"></xsl:value-of>
		</xsl:element>
	</xsl:copy>
</xsl:template>

</xsl:stylesheet> 