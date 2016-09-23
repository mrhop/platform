webpackJsonp([1],{

/***/ 0:
/*!********************************!*\
  !*** ./js/modules/404/404.jsx ***!
  \********************************/
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(React, ReactIntl, ReactDOM, UtilFun) {/* REACT HOT LOADER */ if (false) { (function () { var ReactHotAPI = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-api\\modules\\index.js"), RootInstanceProvider = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\RootInstanceProvider.js"), ReactMount = require("react/lib/ReactMount"), React = require("react"); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {
	
	'use strict';
	
	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();
	
	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }
	
	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }
	
	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }
	
	/**
	 * Created by Donghui Huo on 2016/5/6.
	 */
	
	__webpack_require__(/*! ./404.scss */ 548);
	
	var ErrorPage404 = function (_React$Component) {
	    _inherits(ErrorPage404, _React$Component);
	
	    function ErrorPage404(props) {
	        _classCallCheck(this, ErrorPage404);
	
	        return _possibleConstructorReturn(this, (ErrorPage404.__proto__ || Object.getPrototypeOf(ErrorPage404)).call(this, props));
	    }
	
	    _createClass(ErrorPage404, [{
	        key: 'render',
	        value: function render() {
	            return React.createElement(
	                'div',
	                null,
	                React.createElement(
	                    'h1',
	                    null,
	                    React.createElement(ReactIntl.FormattedMessage, { id: '404.error' })
	                ),
	                React.createElement(
	                    'p',
	                    null,
	                    React.createElement(ReactIntl.FormattedMessage, { id: '404.sorrySentence' }),
	                    React.createElement(
	                        'a',
	                        { href: '/' },
	                        React.createElement(ReactIntl.FormattedMessage, {
	                            id: '404.backHome' })
	                    )
	                )
	            );
	        }
	    }]);
	
	    return ErrorPage404;
	}(React.Component);
	
	ReactDOM.render(React.createElement(
	    ReactIntl.IntlProvider,
	    { locale: locale, messages: UtilFun.getIntl('404') },
	    React.createElement(ErrorPage404, null)
	), document.querySelector('.page-not-found-modal'));
	
	/* REACT HOT LOADER */ }).call(this); } finally { if (false) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = require("D:\\workspaces\\html\\platform\\platform_user\\node_modules\\react-hot-loader\\makeExportsHot.js"); if (makeExportsHot(module, require("react"))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "404.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(/*! react */ 2), __webpack_require__(/*! react-intl */ 270), __webpack_require__(/*! react-dom */ 35), __webpack_require__(/*! ./js/util/utilFun */ 268)))

/***/ },

/***/ 548:
/*!*********************************!*\
  !*** ./js/modules/404/404.scss ***!
  \*********************************/
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag
	
	// load the styles
	var content = __webpack_require__(/*! !./../../../../~/css-loader!./../../../../~/sass-loader!./404.scss */ 549);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(/*! ./../../../../~/style-loader/addStyles.js */ 263)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../node_modules/css-loader/index.js!./../../../../node_modules/sass-loader/index.js!./404.scss", function() {
				var newContent = require("!!./../../../../node_modules/css-loader/index.js!./../../../../node_modules/sass-loader/index.js!./404.scss");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 549:
/*!******************************************************************!*\
  !*** ../~/css-loader!../~/sass-loader!./js/modules/404/404.scss ***!
  \******************************************************************/
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(/*! ./../../../../~/css-loader/lib/css-base.js */ 262)();
	// imports
	
	
	// module
	exports.push([module.id, "/**\r\n * Created by Donghui Huo on 2016/5/6.\r\n */\nhtml#page-404 {\n  height: 100%; }\n  html#page-404 body {\n    display: -webkit-flex;\n    display: flex;\n    -webkit-align-items: center;\n    align-items: center;\n    width: 100%;\n    margin: auto;\n    height: 100%; }\n\n.page-not-found-modal {\n  width: 638px;\n  margin: 0 auto;\n  background: rgba(0, 0, 0, 0.5);\n  border-radius: 5px;\n  font-weight: 300;\n  color: #fff;\n  padding: 32px;\n  text-align: center;\n  box-sizing: content-box; }\n  .page-not-found-modal h1 {\n    font-weight: 300;\n    margin-bottom: 32px; }\n  .page-not-found-modal p {\n    font-size: 16px;\n    line-height: 24px; }\n  .page-not-found-modal a {\n    text-decoration: none;\n    outline: 0;\n    display: inline-block; }\n", ""]);
	
	// exports


/***/ }

});
//# sourceMappingURL=404.js.map