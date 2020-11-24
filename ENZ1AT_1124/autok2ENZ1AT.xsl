<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xsl:template match="/">
	<xsl:value-of select="count(//auto[ar>30000])" />
</xsl:template>

</xsl:stylesheet> 