webpackJsonp([3],{

/***/ 0:
/*!************************************!*\
  !*** ./js/modules/login/login.jsx ***!
  \************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(ConfigureStore, MiddleWare, ReactDOM, React, ReactIntl, UtilFun, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _DevTools = __webpack_require__(/*! ../common/containers/DevTools */ 554);
	
	var _DevTools2 = _interopRequireDefault(_DevTools);
	
	var _login = __webpack_require__(/*! ./reducers/login */ 899);
	
	var _login2 = _interopRequireDefault(_login);
	
	var _LoginInternal = __webpack_require__(/*! ./containers/LoginInternal */ 901);
	
	var _LoginInternal2 = _interopRequireDefault(_LoginInternal);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	var store = ConfigureStore.configureStore({ reducer: _login2.default, middleware: [MiddleWare.defaultCall] });
	ReactDOM.render(React.createElement(
	    ReactIntl.IntlProvider,
	    { locale: locale, messages: UtilFun.getIntl('auth') },
	    React.createElement(
	        ReactRedux.Provider,
	        { store: store },
	        React.createElement(_LoginInternal2.default, null)
	    )
	), document.querySelector('.auth-main'));
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "login.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/store/configureStore.js */ 550), __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364), __webpack_require__(/*! react-dom */ 35), __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/util/utilFun */ 268), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 850:
/*!**************************************************!*\
  !*** ./js/modules/common/form/reducers/index.js ***!
  \**************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _actions = __webpack_require__(/*! ../actions */ 363);
	
	var ActionTypes = _interopRequireWildcard(_actions);
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function main() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.FORM_INIT) {
	        //from 初始化时设置，判断id是否存在
	        state[action.formKey] = {};
	        state[action.formKey].rule = action.rule;
	        state[action.formKey].status = 'init';
	        state[action.formKey].submitProcess = { status: false };
	        return l_merge({}, state);
	    }
	    if (action.type === ActionTypes.FORM_VALIDATE_FAILURE) {
	        state[action.formKey].rule.structure = action.structure;
	        state[action.formKey].submitProcess = { status: false };
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.FORM_POST_SUCCESS) {
	        //将action.response和 validateFailureMsg 合并,并返回;
	        state[action.requestCondition.formKey].submitProcess = { status: false };
	        if (action.response) {
	            state[action.requestCondition.formKey].status = action.response.status;
	            if (action.response.message) {
	                state[action.requestCondition.formKey].message = action.response.message;
	            }
	            if (action.response.responseData) {
	                state[action.requestCondition.formKey].responseData = action.response.responseData;
	            }
	        }
	        return l_merge({}, state);
	    }
	
	    if (action.type === ActionTypes.FORM_POST_FAILURE) {
	        state[action.requestCondition.formKey].submitProcess = { status: false };
	        state[action.requestCondition.formKey].status = 'serverFailure';
	        state[action.requestCondition.formKey].failureMsg = action.error;
	        return l_merge({}, state);
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ main: main });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 899:
/*!********************************************!*\
  !*** ./js/modules/login/reducers/login.js ***!
  \********************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(l_merge, Redux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _login = __webpack_require__(/*! ../actions/login */ 900);
	
	var ActionTypes = _interopRequireWildcard(_login);
	
	var _reducers = __webpack_require__(/*! ../../common/form/reducers */ 850);
	
	var _reducers2 = _interopRequireDefault(_reducers);
	
	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }
	
	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }
	
	function client() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];
	    var action = arguments[1];
	
	    if (action.type === ActionTypes.INIT_CLIENT_SUCCESS) {
	        if (action.response.status && action.response.status === "success") {
	            state = { clientValidated: true };
	            //此处写入cookie
	            return l_merge({}, state);
	        } else {
	            console.log(action.response.status + " : " + action.response.message);
	        }
	    }
	    return state;
	}
	
	exports.default = Redux.combineReducers({ client: client, form: _reducers2.default });
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "login.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! lodash/merge */ 510), __webpack_require__(/*! redux */ 349)))

/***/ },

/***/ 900:
/*!*******************************************!*\
  !*** ./js/modules/login/actions/login.js ***!
  \*******************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(MiddleWare) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.initClientLoginDispatch = initClientLoginDispatch;
	
	function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }
	
	var INIT_CLIENT_REQUEST = exports.INIT_CLIENT_REQUEST = 'INIT_CLIENT_REQUEST';
	var INIT_CLIENT_SUCCESS = exports.INIT_CLIENT_SUCCESS = 'INIT_CLIENT_SUCCESS';
	var INIT_CLIENT_FAILURE = exports.INIT_CLIENT_FAILURE = 'INIT_CLIENT_FAILURE';
	
	function initClientLogin(requestCondition) {
	    return _defineProperty({}, MiddleWare.CALL_API, {
	        httpType: 'get',
	        types: [INIT_CLIENT_REQUEST, INIT_CLIENT_SUCCESS, INIT_CLIENT_FAILURE],
	        //endpoint: `/oauth2client/byclient`,
	        endpoint: requestCondition.endpoint
	    });
	}
	
	function initClientLoginDispatch(requestCondition) {
	    return function (dispatch, getState) {
	        return dispatch(initClientLogin(requestCondition));
	    };
	}
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "login.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! ./js/modules/common/middleware/index.js */ 364)))

/***/ },

/***/ 901:
/*!******************************************************!*\
  !*** ./js/modules/login/containers/LoginInternal.js ***!
  \******************************************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, Modal, ReactIntl, Form, ReactRedux) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	var _actions = __webpack_require__(/*! ../../common/form/actions */ 363);
	
	var _login = __webpack_require__(/*! ../actions/login */ 900);
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	__webpack_require__(/*! ./LoginInternal.scss */ 902);
	
	var Login = function (_React$Component) {
	    _inherits(Login, _React$Component);
	
	    function Login(props) {
	        _classCallCheck(this, Login);
	
	        var _this = _possibleConstructorReturn(this, (Login.__proto__ || Object.getPrototypeOf(Login)).call(this, props));
	
	        _this.state = { submitProcess: false };
	        _this.submitUrl = baseUrl + "gettokenbypassword";
	        _this.initRule = {
	            structure: [{
	                name: 'username',
	                label: _this.props.intl.formatMessage({ id: 'auth.user' }),
	                type: 'text',
	                placeholder: _this.props.intl.formatMessage({ id: 'auth.user.placeholder' }),
	                required: true,
	                validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	            }, {
	                name: 'password',
	                label: _this.props.intl.formatMessage({ id: 'auth.password' }),
	                type: 'password',
	                placeholder: _this.props.intl.formatMessage({ id: 'auth.password' }),
	                required: true,
	                validateRules: [{ name: _actions.VALIDATE_RULE.REQUIRED_VALIDATE.name, errorMsg: '不能为空' }]
	            }],
	            submit: { label: '登录' }
	        };
	        return _this;
	    }
	
	    _createClass(Login, [{
	        key: 'callbackFailure',
	        value: function callbackFailure(data) {
	            var modalValue = {
	                content: React.createElement(
	                    'span',
	                    null,
	                    '请确认用户信息正确并有权访问该系统'
	                ),
	                title: '登陆失败',
	                footerCloseButton: {
	                    visible: true,
	                    title: '关闭'
	                }
	            };
	            Modal.createModal.bind(this, { modalValues: modalValue, type: 'messageError' })();
	        }
	    }, {
	        key: 'callbackSuccess',
	        value: function callbackSuccess(data) {
	            location.href = baseUrl + data.redirect;
	        }
	    }, {
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	
	            //data init
	            //该属性从何得出
	            this.props.initClientLoginDispatch({ endpoint: baseUrl + "gettokenbyclient" });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return this.props.clientValidated ? React.createElement(
	                'div',
	                { className: 'auth-block' },
	                React.createElement(
	                    'h1',
	                    null,
	                    React.createElement(ReactIntl.FormattedMessage, { id: 'auth.signIn',
	                        values: { appName: globalProps['app.name'], adminPlatform: globalProps['app.adminPlatform'] } })
	                ),
	                React.createElement(Form.HorizontalForm, { url: this.submitUrl, failureCallback: this.callbackFailure.bind(this),
	                    callback: this.callbackSuccess.bind(this),
	                    initRule: this.initRule,
	                    symbol: 'form-login' })
	            ) : null;
	        }
	    }]);
	
	    return Login;
	}(React.Component);
	
	Login.propTypes = {
	    clientValidated: React.PropTypes.bool,
	    initClientLoginDispatch: React.PropTypes.func.isRequired
	};
	
	function mapStateToProps(state, ownProps) {
	    if (state && state.client) {
	        var clientValidated = state.client.clientValidated;
	
	        return { clientValidated: clientValidated };
	    } else {
	        return {};
	    }
	}
	
	var reactLogin = ReactRedux.connect(mapStateToProps, {
	    initClientLoginDispatch: _login.initClientLoginDispatch
	})(Login);
	
	exports.default = ReactIntl.injectIntl(reactLogin);
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LoginInternal.js" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! ./js/modules/common/modal/modal.jsx */ 267), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! ./js/modules/common/form/form.jsx */ 341), __webpack_require__(/*! react-redux */ 342)))

/***/ },

/***/ 902:
/*!********************************************************!*\
  !*** ./js/modules/login/containers/LoginInternal.scss ***!
  \********************************************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../../~/css-loader!./../../../../../~/sass-loader!./LoginInternal.scss */ 903);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../node_modules/css-loader/index.js!./../../../../../node_modules/sass-loader/index.js!./LoginInternal.scss", function() {
				var newContent = require("!!./../../../../../node_modules/css-loader/index.js!./../../../../../node_modules/sass-loader/index.js!./LoginInternal.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 903:
/*!*****************************************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/login/containers/LoginInternal.scss ***!
  \*****************************************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "html#auth, html#auth body, .auth-main {\n  height: 100%;\n  position: relative; }\n\n.auth-main {\n  margin: auto;\n  width: 100%;\n  display: -webkit-flex;\n  display: flex;\n  -webkit-align-items: center;\n  align-items: center; }\n\n.auth-block {\n  width: 540px;\n  margin: 0 auto;\n  border-radius: 5px;\n  background: rgba(0, 0, 0, 0.55);\n  color: #fff;\n  padding: 32px; }\n\n.auth-block h1 {\n  font-weight: normal;\n  margin-bottom: 28px; }\n\n.auth-block h1 {\n  text-align: center; }\n\n.auth-link {\n  text-decoration: none;\n  text-align: center;\n  display: block;\n  font-size: 16px;\n  margin-bottom: 33px; }\n\n.form-group label {\n  font-weight: 400;\n  font-size: 13px; }\n\n.form-control {\n  border: none; }\n\n.form-control:focus {\n  box-shadow: none; }\n\na.forgot-pass {\n  display: block;\n  text-align: right;\n  margin-bottom: -20px;\n  float: right;\n  z-index: 2;\n  position: relative; }\n", ""]);
	
	// exports


/***/ }

});
//# sourceMappingURL=login.js.map