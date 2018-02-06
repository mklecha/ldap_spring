<#if username?has_content>
    Hello ${username}
    Question: ${question}
    <form method="post" action="/passwordRemind">
        <label>
            Answer
            <input name="answer">
        </label>
        <label>
            New password
            <input name="password" type="password">
        </label>
        <button>Send</button>
    </form>
<#else>
    <form method="get" action="/passwordRemind">
        <label>
            Input your username
            <input name="username">
        </label>
        <button>Send</button>
    </form>
</#if>