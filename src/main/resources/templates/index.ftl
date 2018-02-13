<h1>Change user info</h1>
<form method="post" action="/changeInfo">
    <label>
        Name
        <input name="name">
    </label>
    <label>
        Surname
        <input name="surname">
    </label>
    <label>
        Mail
        <input name="mail">
    </label>
    <button>Save</button>
</form>

<h1>Change user password</h1>
<form method="post" action="/changePass">
    <label>
        Password
        <input name="password" type="password">
    </label>
    <label>
        Question
        <input name="question">
    </label>
    <label>
        Answer
        <input name="answer">
    </label>
    <button>Save</button>
</form>

<h1>Activate Google Auth</h1>
<form method="post" action="/activateAuth">
	<label>
        Name
        <input name="name">
    </label>
    <button>Activate</button>
</form>

<h1>Remove Google Auth</h1>
<form method="post" action="/removeAuth">
    <button>Remove</button>
</form>
