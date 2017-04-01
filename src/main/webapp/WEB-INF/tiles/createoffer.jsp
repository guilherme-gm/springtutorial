
        <%-- commandName : nome do atributo no método --%>
        <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

            <table class="formtable">
                <tr>
                    <td class="label">Name: </td>
                    <td>
                        <sf:input path="name" class="control" name="name" type="text" /><br />
                        <sf:errors path="name" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label">Email: </td>
                    <td>
                        <sf:input path="email" class="control"  name="email" type="text" /><br />
                        <sf:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label">Your offer: </td>
                    <td>
                        <sf:textarea path="text" class="control"  name="text" rows="10" cols="10"></sf:textarea><br />
                        <sf:errors path="text" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label"> </td>
                    <td><input class="control"  value="Create advert" type="submit" /></td>
                </tr>
            </table>

        </sf:form>

        <%--
        <form method="post" action="${pageContext.request.contextPath}/docreate">

            <table class="formtable">
                <tr><td class="label">Name: </td><td><input class="control" name="name" type="text" /></td></tr>
                <tr><td class="label">Email: </td><td><input class="control"  name="email" type="text" /></td></tr>
                <tr><td class="label">Your offer: </td><td><textarea class="control"  name="text" rows="10" cols="10"></textarea></td></tr>
                <tr><td class="label"> </td><td><input class="control"  value="Create advert" type="submit" /></td></tr>
            </table>

        </form>
        --%>