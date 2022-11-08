<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <html><xsl:apply-templates /></html>
    </xsl:template>
    <xsl:template match='Personas'>
        <head><title>LISTADO DE PERSONAS</title></head>
        <body><center>
            <h1>LISTA DE PERSONA</h1>
            <table border='1'>
                <tr>
                    <th>dni</th>
                    <th>nombre</th>
                    <th>apellido</th>
                    <th>edad</th>
                    <th>casado</th>
                    <th>telefono</th>
                    <th>direccion</th>
                </tr>
                <xsl:apply-templates select='Persona' />
            </table>
        </center>
        </body>
    </xsl:template>
    <xsl:template match='Persona'>
        <tr><xsl:apply-templates /></tr>
    </xsl:template>
    <xsl:template match='dni|nombre|apellido|edad|casado|telefono|direccion'>
        <td><xsl:apply-templates /></td>
    </xsl:template>
</xsl:stylesheet>